package com.empresa.funcionarios.application.configurations;

import com.empresa.funcionarios.application.dto.FuncionarioDTO;
import com.empresa.funcionarios.application.dto.FuncionarioReturnDTO;
import com.empresa.funcionarios.domain.entities.Funcionario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // Converte de Entidade para DTO de entrada (FuncionarioDTO)
    public FuncionarioDTO toDTO(Funcionario funcionario) {
        return modelMapper().map(funcionario, FuncionarioDTO.class);
    }

    // Converte de DTO de Entrada para Entidade
    public Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        return modelMapper().map(funcionarioDTO, Funcionario.class);
    }

    // Converte uma lista de entidades para lista de DTOs de Entrada
    public List<FuncionarioDTO> toDTOList(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Converte de Entidade para DTO de Retorno (FuncionarioReturnDTO)
    public FuncionarioReturnDTO toReturnDTO(Funcionario funcionario) {
        return modelMapper().map(funcionario, FuncionarioReturnDTO.class);
    }

    // Converte uma lista de entidades para lista de DTOs de Retorno
    public List<FuncionarioReturnDTO> toReturnDTOList(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(this::toReturnDTO)
                .collect(Collectors.toList());
    }
}
