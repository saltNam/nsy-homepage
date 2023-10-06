package com.nsy.homepage.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class BoardListDetailDto {

    private long seq;

    private String title;
    private String contentText;
    private String contentUrl;
    private String uploadFile;
    private String uploadFileYn;
    private String uploadFilePath;
    private String regTime;

    @QueryProjection
    public BoardListDetailDto(long seq, String title, String contentText, String contentUrl, String uploadFile, String uploadFileYn, String uploadFilePath, String regTime) {
        this.seq = seq;
        this.title = title;
        this.contentText = contentText;
        this.contentUrl = contentUrl;
        this.uploadFile = uploadFile;
        this.uploadFileYn = uploadFileYn;
        this.uploadFilePath = uploadFilePath;
        this.regTime = regTime;
    }
}
