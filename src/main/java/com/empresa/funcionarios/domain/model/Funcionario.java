package com.empresa.funcionarios.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Funcionario {

    private final UUID id;
    private String nome;
    private String cargo;
    private BigDecimal salario;
    private LocalDate dataEmissao;
    private boolean ativo;

    public Funcionario(UUID id, String nome, String cargo, BigDecimal salario, LocalDate dataEmissao, boolean ativo) {
        this.id = id;
        this.nome = Objects.requireNonNull(nome);
        this.cargo = Objects.requireNonNull(cargo);
        this.salario = salario;
        this.dataEmissao = dataEmissao != null ? dataEmissao : LocalDate.now();
        this.ativo = ativo;
    }

    public static Funcionario criar(String nome, String cargo, BigDecimal salario, LocalDate dataEmissao) {
        return new Funcionario(UUID.randomUUID(), nome, cargo, salario, dataEmissao, true);
    }

    public void atualizarDados(String nome, String cargo, BigDecimal salario) {
        validarSalario(salario);
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void desativar() {
        this.ativo = false;
    }

    private void validarSalario(BigDecimal salario) {
        if (salario == null || salario.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo.");
        }
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public BigDecimal getSalario() { return salario; }
    public LocalDate getDataEmissao() { return dataEmissao; }
    public boolean isAtivo() { return ativo; }
}
