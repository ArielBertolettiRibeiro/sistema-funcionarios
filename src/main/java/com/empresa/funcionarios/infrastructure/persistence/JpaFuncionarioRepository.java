package com.empresa.funcionarios.infrastructure.persistence;

import com.empresa.funcionarios.domain.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JpaFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByIdAndActiveTrue(Long id);
    Page<Funcionario> findAll(Pageable pageable);
    void deactivateById(Long id);
}
