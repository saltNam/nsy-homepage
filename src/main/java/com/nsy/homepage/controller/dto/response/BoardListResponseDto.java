package com.nsy.homepage.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardListResponseDto {

    // 게시물 총 개수
    private long count;

    // 게시물 리스트
    private List<BoardListDto> boardList;
}
