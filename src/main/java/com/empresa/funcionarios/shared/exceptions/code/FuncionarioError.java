package com.empresa.funcionarios.shared.exceptions.code;

import com.empresa.funcionarios.shared.exceptions.ErrorCode;
import org.springframework.http.HttpStatus;

public enum FuncionarioError implements ErrorCode {

    NOT_FOUND("FUNCIONARIO.NOT_FOUND", "funcionario.not.found", HttpStatus.NOT_FOUND);

    private final String code;
    private final String i18nKey;
    private final HttpStatus status;

    FuncionarioError(String code, String i18nKey, HttpStatus status) {
        this.code = code;
        this.i18nKey = i18nKey;
        this.status = status;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String i18nKey() {
        return i18nKey;
    }

    @Override
    public HttpStatus httpStatus() {
        return status;
    }
}
