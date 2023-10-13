package com.nsy.homepage.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public enum ErrorCode {

    // COMMON
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청 입니다", "400"),

    // homepage
    NOT_EXIST_CATEGORY_EXCEPTION(HttpStatus.BAD_REQUEST,"조회할 수 있는 올바른 카테고리가 아닙니다","W000"),
    NOT_EXIST_BOARD_DETAIL_EXCEPTION(HttpStatus.BAD_REQUEST,"조회할 수 있는 게시물이 존재하지 않아요","W001"),
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "입력 데이터가 올바르지 않습니다", "W002");

    private final HttpStatus httpStatus;
    private final String message;
    private final String errorCode;
    private final int code;

    ErrorCode(HttpStatus httpStatus, String message, String errorCode) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errorCode = errorCode;
        this.code = httpStatus.value();
    }
}
