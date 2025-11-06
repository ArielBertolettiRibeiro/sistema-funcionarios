package com.empresa.funcionarios.application.funcionario.service;

import com.empresa.funcionarios.domain.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncionarioService {
    boolean existePorId(Long id);
    Funcionario findById(Long id);
    Page<Funcionario> findAll(Pageable pageable);
}
