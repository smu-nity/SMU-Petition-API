package com.smunity.petition.global.common.code;

import com.smunity.petition.global.common.ApiResponse;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();

    HttpStatus getHttpStatus();

    String getCode();

    String getMessage();

    ApiResponse<Void> getErrorResponse();
}
