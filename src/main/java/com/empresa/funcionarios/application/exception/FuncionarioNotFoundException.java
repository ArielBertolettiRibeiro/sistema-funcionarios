package com.empresa.funcionarios.application.exception;

public class FuncionarioNotFoundException extends RuntimeException {

    public FuncionarioNotFoundException(String texto) {
        super(texto);
    }
}
