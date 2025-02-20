package com.empresa.funcionarios.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "funcionarios")
@Data
@NoArgsConstructor
@Entity
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
    private LocalDate dataEmissao; //Não pode ser futura

    public Funcionario(String nome, String cargo, BigDecimal salario, LocalDate dataEmissao) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dataEmissao = dataEmissao;
    }
}
