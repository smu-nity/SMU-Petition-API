package com.smunity.petition.global.common.exception;

import com.smunity.petition.global.common.code.BaseErrorCode;

public class CustomException extends RuntimeException {
    private final BaseErrorCode errorCode;

    public CustomException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
