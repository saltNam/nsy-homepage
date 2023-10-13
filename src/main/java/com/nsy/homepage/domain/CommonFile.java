package com.nsy.homepage.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class CommonFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "파일 순번", example = "1")
    @Column(length = 11)
    private Long seq;
    @Schema(description = "파일 타입", example = "content")
    @Column(length = 30)
    private String fileType;
    @Schema(description = "파일 경로", example = "/resources/efs/content/2019/10/@visual_thum_20191021140405.jpg")
    @Column(length = 100)
    private String filePath;
    @Schema(description = "물리적으로 저장되는 파일명", example = "visual_thum_20191021140405.jpg")
    @Column(length = 100)
    private String fileName;
    @Schema(description = "원본 파일명", example = "@visual_thum.jpg")
    @Column(length = 100)
    private String orgName;
    @Schema(description = "등록 시간")
    private LocalDateTime regTime;
    @OneToOne
    private CommonBoard f;
}
