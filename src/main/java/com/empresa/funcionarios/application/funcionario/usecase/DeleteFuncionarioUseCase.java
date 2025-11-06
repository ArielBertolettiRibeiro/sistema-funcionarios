package com.empresa.funcionarios.application.funcionario.usecase;

import com.empresa.funcionarios.application.funcionario.service.FuncionarioService;
import com.empresa.funcionarios.infrastructure.persistence.JpaFuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteFuncionarioUseCase {

    private final JpaFuncionarioRepository repository;
    private final FuncionarioService service;

    public void execute(Long id) {
        service.findById(id);
        repository.deleteById(id);
    }
}
