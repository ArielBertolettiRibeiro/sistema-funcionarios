package com.empresa.funcionarios.infrastructure.http;

import org.springframework.http.HttpStatus;

public class ErrorStatusMapper {
    public static HttpStatus toStatus(String code) {
        return switch (code) {
            case "FUNCIONARIO.NOT_FOUND" -> HttpStatus.NOT_FOUND;
            default -> HttpStatus.BAD_REQUEST;
        };
    }
}
