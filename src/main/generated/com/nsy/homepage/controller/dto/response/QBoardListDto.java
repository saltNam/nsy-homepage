package com.nsy.homepage.controller.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.nsy.homepage.controller.dto.response.QBoardListDto is a Querydsl Projection type for BoardListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardListDto extends ConstructorExpression<BoardListDto> {

    private static final long serialVersionUID = -1963798944L;

    public QBoardListDto(com.querydsl.core.types.Expression<Long> seq, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> contentText, com.querydsl.core.types.Expression<String> contentUrl, com.querydsl.core.types.Expression<String> regTime) {
        super(BoardListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class}, seq, title, contentText, contentUrl, regTime);
    }

}

