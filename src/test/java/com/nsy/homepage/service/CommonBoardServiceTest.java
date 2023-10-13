package com.nsy.homepage.service;

import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.BoardDetailResponseDto;
import com.nsy.homepage.controller.dto.response.BoardListResponseDto;
import com.nsy.homepage.error.ApiException;
import com.nsy.homepage.repository.CommonBoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class CommonBoardServiceTest {

    @Autowired
    CommonBoardService commonBoardService;

    @Autowired
    CommonBoardRepository commonBoardRepository;

    @Test
    void getNoticeList() {
        // given
        GetBoardListDto request = GetBoardListDto.builder()
                .page(1)
                .limit(4)
                .build();

        // when
        BoardListResponseDto result = commonBoardService.getBoardList(request, "news");

        // then
        assertThat(result.getBoardList().size()).isEqualTo(1);   // 노출된 공지사항은 1개뿐
    }

    @Test
    void getNewsList() {
        //given
        GetBoardListDto requestDto = GetBoardListDto.builder()
                .page(1)
                .limit(4)
                .build();

        //when
        BoardListResponseDto boardListResponseDto = commonBoardService.getBoardList(requestDto,"news");
        //then
        assertThat(boardListResponseDto.getBoardList().size()).isEqualTo(4);
        assertThat(boardListResponseDto.getCount()).isEqualTo(35);
    }

    @Test
    void getIrList() {
        //given
        GetBoardListDto requestDto = GetBoardListDto.builder()
                .page(1)
                .limit(4)
                .build();

        //when
        BoardListResponseDto boardListResponseDto = commonBoardService.getBoardList(requestDto,"ir");
        //then
        assertThat(boardListResponseDto.getBoardList().size()).isEqualTo(0);
    }


    @Test
    void getNoticeDetail(){
        //given
        String category = "notice";
        Long seq = 129L;
        //when
        BoardDetailResponseDto boardDetail = commonBoardService.getBoardDetail(category, seq);
        //then
        assertThat(boardDetail.getTitle()).isEqualTo("새로운 보험 비교 서비스 '보답'을 만나보세요.");
    }

    @Test
    void getNewsDetail(){
        //given
        String category = "news";
        Long seq = 1L;
        //when
        BoardDetailResponseDto boardDetail = commonBoardService.getBoardDetail(category, seq);
        //then
        // news는 상세 페이지가 없어서 조회시 예외 발생
      /*  Assertions.assertThatThrownBy(() -> commonBoardService.getBoardDetail(category, seq))
                .isInstanceOf(ApiException.class);*/
    }

    @Test
    void getIrDetail(){
        //given
        String category = "ir";
        Long seq = 1L;
        //when
        BoardDetailResponseDto boardDetail = commonBoardService.getBoardDetail(category, seq);
        //then
    }


}
