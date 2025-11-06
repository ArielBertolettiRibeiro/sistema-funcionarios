package com.empresa.funcionarios.shared.exceptions.code;

import com.empresa.funcionarios.shared.exceptions.ErrorCode;

public enum FuncionarioError implements ErrorCode {
    NOT_FOUND("FUNCIONARIO.NOT_FOUND", "funcionario.not.found");

    private final String code;
    private final String i18nKey;

    FuncionarioError(String code, String i18nKey) {
        this.code = code;
        this.i18nKey = i18nKey;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String i18nKey() {
        return i18nKey;
    }
    ;


}
