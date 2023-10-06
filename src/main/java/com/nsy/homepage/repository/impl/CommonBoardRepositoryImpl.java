package com.nsy.homepage.repository.impl;


import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.BoardListDto;
import com.nsy.homepage.controller.dto.response.BoardListResponseDto;
import com.nsy.homepage.controller.dto.response.QBoardListDto;
import com.nsy.homepage.repository.custom.CommonBoardRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.nsy.homepage.domain.QCommonBoard.commonBoard;


@Repository
@RequiredArgsConstructor
// 쿼리문 작성
public class CommonBoardRepositoryImpl implements CommonBoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public BoardListResponseDto getBoardList(GetBoardListDto getBoardListDto) {
        List<BoardListDto> boardListDto = queryFactory.select(
                new QBoardListDto(
                        commonBoard.seq,
                        commonBoard.title,
                        commonBoard.contentText,
                        commonBoard.contentUrl,
                        commonBoard.regTime))
                .from(commonBoard)
                .where(commonBoard.useYn.eq("Y")
                        .and(commonBoard.delYn.eq("N"))
                        .and(commonBoard.useFrontYn.eq("Y"))
                        .and(commonBoard.regTime.isNotNull())
                        .and(commonBoard.category.eq(getBoardListDto.getCategory())))
                .limit(getBoardListDto.getLimit())
                .offset(getBoardListDto.getOffset())
                .fetch();

        Long count = queryFactory
                        .selectFrom(commonBoard)
                        .where(commonBoard.useYn.eq("Y")
                            .and(commonBoard.delYn.eq("N"))
                            .and(commonBoard.useFrontYn.eq("Y"))
                            .and(commonBoard.regTime.isNotNull())
                            .and(commonBoard.category.eq(getBoardListDto.getCategory())))
                        .fetchCount();

        BoardListResponseDto response = BoardListResponseDto.builder()
                .boardList(boardListDto)
                .count(count)
                .build();

        return response;
    }


}
