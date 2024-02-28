package com.smunity.petition.global.common.exception;

import com.smunity.petition.global.common.ApiResponse;
import com.smunity.petition.global.common.code.BaseErrorCode;
import com.smunity.petition.global.common.code.status.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResponse<String>> handleAllException(Exception e) {
        log.error(">>>>> Internal Server Error : ", e);
        BaseErrorCode errorCode = ErrorCode._INTERNAL_SERVER_ERROR;
        ApiResponse<String> errorResponse = ApiResponse.onFailure(
                errorCode.getCode(),
                errorCode.getMessage(),
                e.getMessage()
        );
        return ResponseEntity.internalServerError().body(errorResponse);
    }

    @ExceptionHandler({GeneralException.class})
    public ResponseEntity<ApiResponse<Void>> handleCustomException(GeneralException e) {
        log.warn(">>>>> Custom Exception : {}", e.getMessage());
        BaseErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(errorCode.getErrorResponse());
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ApiResponse<Object> handleIntegrityConstraint(DataIntegrityViolationException e) {
        log.warn(">>>>> Data Integrity Violation Exception : {}", e.getMessage());
        BaseErrorCode errorStatus = ErrorCode.USER_ALREADY_EXIST;
        return ApiResponse.onFailure(
                errorStatus.getCode(),
                errorStatus.getMessage()
        );
    }
}
