package com.nsy.homepage.repository.impl;


import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.*;
import com.nsy.homepage.repository.custom.CommonBoardRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.nsy.homepage.domain.QCommonBoard.commonBoard;
import static com.nsy.homepage.domain.QCommonFile.commonFile;


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

    @Override
    public BoardDetailResponseDto getBoardDetail(String category, long seq) {
        BoardDetailResponseDto boardDetailResponseDto = queryFactory.select(
                new QBoardDetailResponseDto(
                        commonBoard.seq,
                        commonBoard.title,
                        commonBoard.contentText,
                        commonBoard.contentUrl,
                        commonBoard.uploadFile,
                        commonBoard.useUploadFileYn,
                        commonFile.filePath,
                        commonBoard.regTime))
                .from(commonBoard)
                .leftJoin(commonBoard.commonFile, commonFile)
                .where(commonBoard.useYn.eq("Y")
                        .and(commonBoard.seq.eq(seq))
                        .and(commonBoard.delYn.eq("N"))
                        .and(commonBoard.useFrontYn.eq("Y"))
                        .and(commonBoard.regTime.isNotNull())
                        .and(commonBoard.category.eq(category)))
                        .fetchOne();

        return boardDetailResponseDto;
    }


}
