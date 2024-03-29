package com.smunity.petition.domain.auth.exception;

import com.smunity.petition.global.common.code.BaseErrorCode;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public class AuthExceptionHandler {
    public static Mono<? extends Throwable> handleError(ClientResponse response) {
        BaseErrorCode code = (response.statusCode().value() == 401) ? ErrorCode.AUTH_UNAUTHORIZED : ErrorCode.AUTH_INTERNAL_SERVER_ERROR;
        return Mono.error(new GeneralException(code));
    }
}
