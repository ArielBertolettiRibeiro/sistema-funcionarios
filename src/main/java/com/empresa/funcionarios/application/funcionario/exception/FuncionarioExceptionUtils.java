package com.empresa.funcionarios.application.funcionario.exception;

import com.empresa.funcionarios.shared.exceptions.BusinessException;
import com.empresa.funcionarios.shared.exceptions.code.FuncionarioError;

public class FuncionarioExceptionUtils {

    public static BusinessException userNotFound(Long id) {
        return new BusinessException(
                FuncionarioError.NOT_FOUND.code(),
                FuncionarioError.NOT_FOUND.i18nKey(),
                "Funcionário não encontrado!",
                new Object[]{id}
        );
    }
}
