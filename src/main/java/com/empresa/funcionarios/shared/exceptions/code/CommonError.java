package com.empresa.funcionarios.shared.exceptions.code;

import com.empresa.funcionarios.shared.exceptions.ErrorCode;

public enum CommonError implements ErrorCode {
    UNEXPECTED("COMMON.UNEXPECTED", "common.unexpected"),
    VALIDATION("COMMON.VALIDATION", "common.validation"),
    JSON_INVALID("COMMON.JSON_INVALID", "common.json.invalid");

    private final String code;
    private final String i18nKey;

    CommonError(String code, String i18nKey) {
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
