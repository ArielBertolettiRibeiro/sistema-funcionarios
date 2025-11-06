package com.empresa.funcionarios.domain.repository;

import com.empresa.funcionarios.domain.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {

    Funcionario save(Funcionario funcionario);
    Optional<Funcionario> findById(Long id);
    Page<Funcionario> findAll(Pageable pageable);
    void deleteById(Long id);
}
