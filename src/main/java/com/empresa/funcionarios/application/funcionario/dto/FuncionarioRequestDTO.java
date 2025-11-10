package com.empresa.funcionarios.application.funcionario.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FuncionarioRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O cargo é obrigatório.")
    private String cargo;

    @NotNull(message = "O salário é obrigatório.")
    @DecimalMin(value = "0.00", inclusive = false, message = "O salário deve ser maior que zero.")
    private BigDecimal salario;

    @NotNull(message = "A data de emissão é obrigatória.")
    private LocalDate dataEmissao;

}
