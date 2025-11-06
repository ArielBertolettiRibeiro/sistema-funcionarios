package com.empresa.funcionarios.application.funcionario.usecase;

import com.empresa.funcionarios.application.funcionario.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.application.funcionario.service.FuncionarioService;
import com.empresa.funcionarios.shared.mapper.FuncionarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindFuncionarioByIdUserCase {

    private final FuncionarioService service;
    private final FuncionarioMapper mapper;

    public FuncionarioResponseDTO execute(Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
