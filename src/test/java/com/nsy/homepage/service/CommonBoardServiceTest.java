package com.nsy.homepage.service;

import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.BoardListResponseDto;
import com.nsy.homepage.repository.CommonBoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

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
                .limit(5)
                .build();

        // when
        BoardListResponseDto result = commonBoardService.getBoardList(request, "CD00594");
        // then
        Assertions.assertThat(result.getBoardList().size()).isEqualTo(1);   // 노출된 공지사항은 1개뿐
    }



}
