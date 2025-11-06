package com.empresa.funcionarios.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(nullable = false)
    private Boolean active;

    public Funcionario(String nome, String cargo, BigDecimal salario, LocalDate dataEmissao) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dataEmissao = dataEmissao;
    }

    public void atualizarDados(String nome, String cargo, BigDecimal salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public static Funcionario criar(String nome, String cargo, BigDecimal salario, LocalDate dataEmissao) {
        if (salario.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo.");
        }
        return new Funcionario(nome, cargo, salario, dataEmissao != null ? dataEmissao : LocalDate.now());
    }
}
