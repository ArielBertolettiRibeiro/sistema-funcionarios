package com.empresa.funcionarios.shared.exceptions.code;

import com.empresa.funcionarios.shared.exceptions.ErrorCode;
import org.springframework.http.HttpStatus;

public enum CommonError implements ErrorCode {
    UNEXPECTED("COMMON.UNEXPECTED", "common.unexpected", HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION("COMMON.VALIDATION", "common.validation", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_FAILED("COMMON.AUTHENTICATION_FAILED", "common.authentication.failed", HttpStatus.UNAUTHORIZED),
    JSON_INVALID("COMMON.JSON_INVALID", "common.json.invalid", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String i18nKey;
    private final HttpStatus status;

    CommonError(String code, String i18nKey, HttpStatus status) {
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
