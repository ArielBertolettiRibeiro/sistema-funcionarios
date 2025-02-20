package com.empresa.funcionarios.domain.exception;

public class FuncionarioNotFoundException extends RuntimeException {

    public FuncionarioNotFoundException(String texto) {
        super(texto);
    }
}
