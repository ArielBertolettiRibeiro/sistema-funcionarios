package com.empresa.funcionarios.infrastructure.config.mapper;

import com.empresa.funcionarios.adapters.dto.FuncionarioRequestDTO;
import com.empresa.funcionarios.adapters.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.domain.entities.Funcionario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper {

    private final ModelMapper modelMapper;

    public Funcionario toEntity(FuncionarioRequestDTO funcionarioDTO) {
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }

    public FuncionarioResponseDTO toResponse(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioResponseDTO.class);
    }

}
