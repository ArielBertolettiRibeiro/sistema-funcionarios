package com.empresa.funcionarios.application.funcionario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FuncionarioResponseDTO {

    private UUID id;
    private String email;
    private String password;
    private String role;
    private boolean active;

}
