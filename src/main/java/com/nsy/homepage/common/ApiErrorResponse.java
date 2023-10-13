package com.nsy.homepage.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

    private int statusCode;
    private String errorCode;
    private String message;

}
