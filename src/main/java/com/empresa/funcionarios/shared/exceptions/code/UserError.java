package com.empresa.funcionarios.shared.exceptions.code;

import com.empresa.funcionarios.shared.exceptions.ErrorCode;
import org.springframework.http.HttpStatus;

public enum UserError implements ErrorCode {

    NOT_FOUND("USER_NOT_FOUND", "user.not.found", HttpStatus.NOT_FOUND),
    EMAIL_IN_USE("USER.EMAIL_IN_USE", "user.email.in.use", HttpStatus.CONFLICT),
    INACTIVE("USER.INACTIVE", "user.inactive", HttpStatus.FORBIDDEN),
    CPF_IN_USE("USER.CPF_IN_USE", "user.cpf.in.use", HttpStatus.CONFLICT),
    USER_BY_USERNAME_NOT_FOUND("USER.BY_USERNAME_NOT_FOUND", "user.by.username.not.found", HttpStatus.UNAUTHORIZED),
    ALREADY_INACTIVE("USER_ALREADY_INACTIVE", "user.already.inactive", HttpStatus.CONFLICT),
    UNAUTHENTICATED("USER_UNAUTHENTICATED", "user.unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED_UPDATE("USER_UNAUTHORIZED_UPDATE", "user.unauthorized.update", HttpStatus.FORBIDDEN),
    ALREADY_HAS_ROLE("USER.ALREADY_HAS_ROLE", "user.already.has.role", HttpStatus.BAD_REQUEST),
    ROLE_UPDATE_NOT_ALLOWED("USER.ROLE_UPDATE_NOT_ALLOWED", "user.role.update.not.allowed", HttpStatus.FORBIDDEN),
    INVALID_CURRENT_PASSWORD("USER.INVALID_CURRENT_PASSWORD", "user.invalid.current.password", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String key;
    private final HttpStatus status;

    UserError(String code, String key, HttpStatus status) {
        this.code = code;
        this.key = key;
        this.status = status;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String i18nKey() {
        return key;
    }

    @Override
    public HttpStatus httpStatus() {
        return status;
    }
}
