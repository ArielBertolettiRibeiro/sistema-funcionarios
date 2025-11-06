package com.empresa.funcionarios.application.funcionario.usecase;

import com.empresa.funcionarios.application.funcionario.dto.FuncionarioRequestDTO;
import com.empresa.funcionarios.application.funcionario.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.application.funcionario.service.FuncionarioService;
import com.empresa.funcionarios.domain.model.Funcionario;
import com.empresa.funcionarios.infrastructure.persistence.JpaFuncionarioRepository;
import com.empresa.funcionarios.shared.mapper.FuncionarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateFuncionarioUseCase {

    private final JpaFuncionarioRepository repository;
    private final FuncionarioService service;
    private final FuncionarioMapper mapper;

    public FuncionarioResponseDTO execute(Long id, FuncionarioRequestDTO request) {
        Funcionario funcionario = service.findById(id);

        funcionario.atualizarDados(request.getNome(), request.getCargo(), request.getSalario());

        return mapper.toResponse(repository.save(funcionario));
    }
}
