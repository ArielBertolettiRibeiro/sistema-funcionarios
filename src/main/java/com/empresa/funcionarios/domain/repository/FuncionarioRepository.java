package com.empresa.funcionarios.domain.repository;

import com.empresa.funcionarios.domain.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository {

    Funcionario save(Funcionario funcionario);
    Optional<Funcionario> findById(UUID uuid);
    Page<Funcionario> findAllActive(Pageable pageable);
}
