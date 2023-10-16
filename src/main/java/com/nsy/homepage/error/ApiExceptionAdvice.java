package com.nsy.homepage.error;

import com.nsy.homepage.common.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  //@ControllerAdvice + @ResponseBody
public class ApiExceptionAdvice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> apiExceptionHandler(ApiException e) {
        e.printStackTrace();

        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ApiErrorResponse.builder()
                        .statusCode(e.getCode())
                        .message(e.getMessage())
                        .errorCode(e.getErrorCode())
                        .build());

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> RunTimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .statusCode(400)
                .message(e.getMessage())
                .errorCode("W000")
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    // 유효성 검사 handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .statusCode(400)
                .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .errorCode("W002")
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
