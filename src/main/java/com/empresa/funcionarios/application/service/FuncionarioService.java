package com.empresa.funcionarios.application.service;

import com.empresa.funcionarios.application.configurations.ModelMapperConfig;
import com.empresa.funcionarios.application.dto.FuncionarioDTO;
import com.empresa.funcionarios.application.dto.FuncionarioReturnDTO;
import com.empresa.funcionarios.domain.entities.Funcionario;
import com.empresa.funcionarios.domain.exception.FuncionarioNotFoundException;
import com.empresa.funcionarios.infrastructure.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class FuncionarioService {

    private ModelMapperConfig modelMapperConfig;
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, ModelMapperConfig modelMapperConfig) {
        this.funcionarioRepository = funcionarioRepository;
        this.modelMapperConfig = modelMapperConfig;
    }

    public FuncionarioReturnDTO created(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = modelMapperConfig.toEntity(funcionarioDTO);
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        return modelMapperConfig.toReturnDTO(funcionarioSalvo);
    }

    public List<FuncionarioReturnDTO> findAll() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return modelMapperConfig.toReturnDTOList(funcionarios);
    }

    public FuncionarioReturnDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado!"));
        return modelMapperConfig.toReturnDTO(funcionario);
    }

    public FuncionarioReturnDTO update(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado"));

        modelMapperConfig.toEntity(funcionarioDTO);
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCargo(funcionarioDTO.getCargo());
        funcionario.setSalario(funcionarioDTO.getSalario());

        Funcionario atualizado = funcionarioRepository.save(funcionario);
        return modelMapperConfig.toReturnDTO(atualizado);
    }

    public void delet(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new FuncionarioNotFoundException("Funcionário não encontrado!");
        }
        funcionarioRepository.deleteById(id);
    }
}
