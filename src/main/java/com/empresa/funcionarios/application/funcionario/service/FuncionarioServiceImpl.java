package com.empresa.funcionarios.application.funcionario.service;

import com.empresa.funcionarios.application.funcionario.exception.FuncionarioExceptionUtils;
import com.empresa.funcionarios.domain.model.Funcionario;
import com.empresa.funcionarios.domain.repository.FuncionarioRepository;
import com.empresa.funcionarios.infrastructure.persistence.JpaFuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService{

    private final FuncionarioRepository repository;

    @Override
    public boolean existePorId(Long id) {
        return false;
    }

    @Override
    public Funcionario findById(Long id) {
        return null;
    }

    @Override
    public Page<Funcionario> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
