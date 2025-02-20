package com.empresa.funcionarios.application.response;

public record ApiResponse<T>(String mensagem, T data) {
}
