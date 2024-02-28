package com.smunity.petition.global.common.code.status;

import com.smunity.petition.global.common.ApiResponse;
import com.smunity.petition.global.common.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode implements BaseErrorCode {
    
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관련 에러
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "USER4002", "닉네임은 필수 입니다."),
    PASSWORD_NOT_EQUAL(HttpStatus.BAD_REQUEST, "USER4003", "비밀번호가 일치하지 않습니다."),
    USER_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "USER4004", "사용자가 이미 존재합니다."),
    SAMNUL_ERROR(HttpStatus.BAD_REQUEST, "SAM4001", "샘물 에러입니다."),

    // 샘물 인증 관련 에러
    AUTH_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH401", "아이디 및 비밀번호가 일치하지 않습니다."),
    AUTH_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH500", "인증 서버 에러, 관리자에게 문의 바랍니다."),

    //question 관련 에러
    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND, "QUESTION404", "해당 질문이 존재하지 않습니다."),
    ANSWER_NOT_FOUND(HttpStatus.NOT_FOUND, "ANSWER404", "해당 답변이 존재하지 않습니다."),
    // petition 관련 에러
    PETITION_NOT_FOUND(HttpStatus.NOT_FOUND, "PETITION404", "해당 청원이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ApiResponse<Void> getErrorResponse() {
        return ApiResponse.onFailure(code, message);
    }
}
