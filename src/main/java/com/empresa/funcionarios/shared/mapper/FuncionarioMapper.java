package com.empresa.funcionarios.shared.mapper;

import com.empresa.funcionarios.application.funcionario.dto.FuncionarioRequestDTO;
import com.empresa.funcionarios.application.funcionario.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.domain.model.Funcionario;
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
