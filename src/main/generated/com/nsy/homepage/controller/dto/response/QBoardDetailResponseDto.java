package com.nsy.homepage.controller.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.nsy.homepage.controller.dto.response.QBoardDetailResponseDto is a Querydsl Projection type for BoardDetailResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardDetailResponseDto extends ConstructorExpression<BoardDetailResponseDto> {

    private static final long serialVersionUID = -358788084L;

    public QBoardDetailResponseDto(com.querydsl.core.types.Expression<Long> seq, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> contentText, com.querydsl.core.types.Expression<String> contentUrl, com.querydsl.core.types.Expression<String> uploadFile, com.querydsl.core.types.Expression<String> uploadFileYn, com.querydsl.core.types.Expression<String> uploadFilePath, com.querydsl.core.types.Expression<String> regTime) {
        super(BoardDetailResponseDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, seq, title, contentText, contentUrl, uploadFile, uploadFileYn, uploadFilePath, regTime);
    }

}

