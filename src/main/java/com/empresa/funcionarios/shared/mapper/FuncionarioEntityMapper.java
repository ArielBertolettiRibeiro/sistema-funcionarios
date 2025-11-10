package com.empresa.funcionarios.shared.mapper;

import com.empresa.funcionarios.application.funcionario.dto.FuncionarioRequestDTO;
import com.empresa.funcionarios.application.funcionario.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.domain.model.Funcionario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioEntityMapper {

    private final ModelMapper mapper;

    public Funcionario toDomain(FuncionarioRequestDTO dto) {
        return mapper.map(dto, Funcionario.class);
    }

    public FuncionarioResponseDTO toResponse(Funcionario funcionario) {
        return mapper.map(funcionario, FuncionarioResponseDTO.class);
    }
}
