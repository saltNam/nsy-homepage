package com.nsy.homepage.service;


import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.BoardDetailResponseDto;
import com.nsy.homepage.controller.dto.response.BoardListResponseDto;
import com.nsy.homepage.error.ApiException;
import com.nsy.homepage.error.ErrorCode;
import com.nsy.homepage.repository.CommonBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonBoardService {

   private final CommonBoardRepository commonBoardRepository;

   // 게시물 개수, 리스트 조회
   public BoardListResponseDto getBoardList(GetBoardListDto getBoardListDto, String category) {
       getBoardListDto.setCategory(convertCategory(category));
       return commonBoardRepository.getBoardList(getBoardListDto);
   }

   // 게시물 상세 조회
   public BoardDetailResponseDto getBoardDetail(String category, long seq) {
       if("news".equals(category)) {    // 뉴스 게시물은 상세보기 없이 뉴스기사로 이동
           throw new ApiException(ErrorCode.NOT_EXIST_BOARD_DETAIL_EXCEPTION);
       }

       BoardDetailResponseDto result = commonBoardRepository.getBoardDetail(convertCategory(category), seq);

       if(result == null) {
           throw new ApiException(ErrorCode.NOT_EXIST_BOARD_DETAIL_EXCEPTION);
       }

        return result;
   }

    // 카테고리 코드로 변환
   private String convertCategory(String category) {
       if(category == null || category == "") {
           throw new ApiException(ErrorCode.NOT_EXIST_CATEGORY_EXCEPTION);
       } else {
           switch (category) {
               case "notice" :
                   category = "CD00594";
                   break;
               case "news" :
                   category = "CD00946";
                   break;
               case "ir" :
                   category = "CD00943";
                   break;
               default :
                   throw new ApiException(ErrorCode.NOT_EXIST_CATEGORY_EXCEPTION);
           }
       }

       return category;
   }

}
