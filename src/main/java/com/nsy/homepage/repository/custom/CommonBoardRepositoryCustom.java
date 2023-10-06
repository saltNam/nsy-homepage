package com.nsy.homepage.repository.custom;



import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.BoardListDto;
import com.nsy.homepage.controller.dto.response.BoardListResponseDto;

import java.util.List;

public interface CommonBoardRepositoryCustom {

    // 게시물 개수, 리스트 조회
    BoardListResponseDto getBoardList (GetBoardListDto getBoardListDto);

}
