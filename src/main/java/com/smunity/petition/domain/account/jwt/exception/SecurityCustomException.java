package com.smunity.petition.domain.account.jwt.exception;

import com.smunity.petition.global.common.code.BaseErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import lombok.Getter;

@Getter
public class SecurityCustomException extends GeneralException {

    private final Throwable cause;

    public SecurityCustomException(BaseErrorCode errorCode) {
        super(errorCode);
        this.cause = null;
    }

    public SecurityCustomException(BaseErrorCode errorCode, Throwable cause) {
        super(errorCode);
        this.cause = cause;
    }
}
