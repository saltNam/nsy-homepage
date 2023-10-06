package com.nsy.homepage.service;


import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.BoardListDto;
import com.nsy.homepage.controller.dto.response.BoardListResponseDto;
import com.nsy.homepage.repository.CommonBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonBoardService {

   private final CommonBoardRepository commonBoardRepository;

   // 게시물 개수, 리스트 조회
   public BoardListResponseDto getBoardList(GetBoardListDto getBoardListDto, String category) {
       getBoardListDto.setCategory(category);
       return commonBoardRepository.getBoardList(getBoardListDto);
   }




}
