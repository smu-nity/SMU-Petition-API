package com.smunity.petition.global.common.code.status;

import com.smunity.petition.global.common.code.BaseErrorCode;
import com.smunity.petition.global.common.code.ErrorReasonDTO;
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

    // 샘물 인증 관련 에러
    AUTH_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH401", "아이디 및 비밀번호가 일치하지 않습니다."),
    AUTH_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH500", "인증 서버 에러, 관리자에게 문의 바랍니다."),

    //question 관련 에러
    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND,"QUESTION404", "해당 질문이 존재하지 않습니다."),
    ANSWER_NOT_FOUND(HttpStatus.NOT_FOUND, "ANSWER404", "해당 답변이 존재하지 않습니다."),
    // petition 관련 에러
    PETITION_NOT_FOUND(HttpStatus.NOT_FOUND, "PETITION404", "해당 청원이 존재하지 않습니다."),

    //respond 관련 에러(for Update)
    RESPOND_NOT_FOUND(HttpStatus.NOT_FOUND, "RESPOND404", "해당 청원 응답이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}
