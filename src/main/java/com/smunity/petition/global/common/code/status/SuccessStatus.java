package com.smunity.petition.global.common.code.status;

import com.smunity.petition.global.common.code.BaseCode;
import com.smunity.petition.global.common.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
	// 일반적인 응답
	_OK(HttpStatus.OK, "COMMON200", "성공입니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;

	@Override
	public ReasonDTO getReason() {
		return ReasonDTO.builder()
			.message(message)
			.code(code)
			.build();
	}

	@Override
	public ReasonDTO getReasonHttpStatus() {
		return ReasonDTO.builder()
			.message(message)
			.code(code)
			.httpStatus(httpStatus)
			.build()
			;
	}
}
