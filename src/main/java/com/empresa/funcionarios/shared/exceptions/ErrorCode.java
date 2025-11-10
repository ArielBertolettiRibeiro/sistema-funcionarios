package com.empresa.funcionarios.shared.exceptions;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String code();
    String i18nKey();
    HttpStatus httpStatus();
}
