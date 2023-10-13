package com.nsy.homepage.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException{
    private String errorCode;
    private int code;
    private HttpStatus httpStatus;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getErrorCode();
        this.code = errorCode.getCode();
        this.httpStatus = errorCode.getHttpStatus();
    }

}
