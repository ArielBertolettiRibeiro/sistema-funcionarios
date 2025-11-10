package com.empresa.funcionarios.infrastructure.persistence.funcionario.jpa;

import com.empresa.funcionarios.infrastructure.persistence.funcionario.entity.FuncionarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaFuncionarioRepository extends JpaRepository<FuncionarioEntity, UUID> {

    Page<FuncionarioEntity> findAllByActiveTrue(Pageable pageable);
}
