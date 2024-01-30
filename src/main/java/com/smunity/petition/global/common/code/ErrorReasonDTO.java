package com.smunity.petition.global.common.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReasonDTO {
	private final String code;
	private final String message;
	private HttpStatus httpStatus;
}
