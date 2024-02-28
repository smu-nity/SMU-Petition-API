package com.smunity.petition.domain.account.exception;


import com.smunity.petition.global.common.code.BaseErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;

public class AccountsExceptionHandler extends GeneralException {
    public AccountsExceptionHandler(BaseErrorCode code) {
        super(code);
    }
}
