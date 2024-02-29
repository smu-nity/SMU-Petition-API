package com.smunity.petition.domain.account.exception;

import com.smunity.petition.global.common.code.BaseErrorCode;
import com.smunity.petition.global.common.exception.CustomException;

public class AccountsExceptionHandler extends CustomException {
    public AccountsExceptionHandler(BaseErrorCode code) {
        super(code);
    }
}
