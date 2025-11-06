package com.empresa.funcionarios.application.funcionario.usecase;

import com.empresa.funcionarios.application.funcionario.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.domain.repository.FuncionarioRepository;
import com.empresa.funcionarios.infrastructure.persistence.JpaFuncionarioRepository;
import com.empresa.funcionarios.shared.mapper.FuncionarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllFuncionariosUseCase {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public Page<FuncionarioResponseDTO> execute(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }
}
