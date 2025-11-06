package com.empresa.funcionarios.application.funcionario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioResponseDTO {

    private Long id;
    private String nome;
    private String cargo;
    private BigDecimal salario;
    private LocalDate dataEmissao;


}
