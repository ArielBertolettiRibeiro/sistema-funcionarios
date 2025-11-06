package com.empresa.funcionarios.infrastructure.persistence.impl;

import com.empresa.funcionarios.domain.model.Funcionario;
import com.empresa.funcionarios.domain.repository.FuncionarioRepository;
import com.empresa.funcionarios.infrastructure.persistence.JpaFuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final JpaFuncionarioRepository jpa;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return jpa.save(funcionario);
    }

    @Override
    public Optional<Funcionario> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Page<Funcionario> findAll(Pageable pageable) {
        return jpa.findAll(pageable);
    }


    @Override
    public void deleteById(Long id) {
    }
}
