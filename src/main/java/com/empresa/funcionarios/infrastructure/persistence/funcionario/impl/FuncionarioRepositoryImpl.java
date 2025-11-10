package com.empresa.funcionarios.infrastructure.persistence.funcionario.impl;

import com.empresa.funcionarios.domain.model.Funcionario;
import com.empresa.funcionarios.domain.repository.FuncionarioRepository;
import com.empresa.funcionarios.infrastructure.persistence.funcionario.jpa.JpaFuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final JpaFuncionarioRepository jpa;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return null;
    }

    @Override
    public Optional<Funcionario> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Page<Funcionario> findAllActive(Pageable pageable) {
        return null;
    }
}
