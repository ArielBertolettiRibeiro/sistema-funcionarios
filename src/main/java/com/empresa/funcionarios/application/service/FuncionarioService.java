package com.empresa.funcionarios.application.service;

import com.empresa.funcionarios.infrastructure.config.mapper.FuncionarioMapper;
import com.empresa.funcionarios.adapters.dto.FuncionarioRequestDTO;
import com.empresa.funcionarios.adapters.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.domain.entities.Funcionario;
import com.empresa.funcionarios.application.exception.FuncionarioNotFoundException;
import com.empresa.funcionarios.infrastructure.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioMapper mapper;
    private final FuncionarioRepository repository;

    @Transactional
    public FuncionarioResponseDTO created(FuncionarioRequestDTO request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Transactional(readOnly = true)
    public Page<FuncionarioResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    @Transactional(readOnly = true)
    public FuncionarioResponseDTO findById(Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado!"));

        return mapper.toResponse(funcionario);
    }

    @Transactional
    public FuncionarioResponseDTO update(Long id, FuncionarioRequestDTO funcionarioDTO) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado"));

        mapper.toEntity(funcionarioDTO);
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCargo(funcionarioDTO.getCargo());
        funcionario.setSalario(funcionarioDTO.getSalario());

        return mapper.toResponse(repository.save(funcionario));
    }

    @Transactional
    public void delet(Long id) {
        if (!repository.existsById(id)) {
            throw new FuncionarioNotFoundException("Funcionário não encontrado!");
        }
        repository.deleteById(id);
    }
}
