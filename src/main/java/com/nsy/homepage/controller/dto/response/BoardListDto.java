package com.nsy.homepage.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class BoardListDto {

    // 게시물 순번
    private Long seq;

    // 게시물 제목
    private String title;

    // 게시물 내용
    private String contentText;

    // 게시물 링크 url
    private String contentUrl;

    // 게시물 등록 시각
    private String regTime;

    @QueryProjection
    public BoardListDto(Long seq, String title, String contentText, String contentUrl, String regTime) {
        this.seq = seq;
        this.title = title;
        this.contentText = contentText;
        this.contentUrl = contentUrl;
        this.regTime = regTime;
    }
}
