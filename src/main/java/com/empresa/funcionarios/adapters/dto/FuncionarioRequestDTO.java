package com.empresa.funcionarios.adapters.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FuncionarioRequestDTO {

    @NotBlank(message = "O nome do funcionário é obrigatorio!")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres!")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "O nome deve conter apenas letras e espaços!")
    private String nome;

    @NotBlank(message = "O cargo do funcionário é obrigatório!")
    @Size(min = 2, max = 50, message = "O cargo deve ter entre 2 e 50 caracteres!")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "O cargo deve conter apenas letras e espaços!")
    private String cargo;

    @NotNull(message = "O salário é obrigatório!")
    @Positive(message = "O salário deve ser maior que zero!")
    private BigDecimal salario;

    @NotNull(message = "A data de emissão é obrigatória!")
    @PastOrPresent(message = "A data me emissão não pode ser futura!")
    private LocalDate dataEmissao;
}
