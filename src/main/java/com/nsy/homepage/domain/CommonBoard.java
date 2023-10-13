package com.nsy.homepage.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CommonBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "게시판 순번", example = "1")
    @Column(length = 11)
    private long seq;
    @Schema(description = "게시판 카테고리 코드", example = "CD00954")
    @Column(length = 45)
    private String category;
    @Schema(description = "게시판 서브 카테고리", example = "3")
    @Column(length = 100)
    private String subCategory;
    @Schema(description = "제목")
    @Column(length = 200)
    private String title;
    @Schema(description = "본문 내용")
    private String contentText;
    private String contentSub;
    @Schema(description = "바로가기 url")
    @Column(length = 200)
    private String contentUrl;
    @Schema(description = "조회수")
    private long hitCnt;
    @Schema(description = "사용 여부(Y/N)")
    private String useYn;
    @Schema(description = "사용자화면 사용 여부(Y/N)")
    private String useFrontYn;
    @Schema(description = "공개 여부(Y/N)")
    private String delYn;
    @Schema(description = "팝업 여부(Y/N)")
    private String popupYn;
    @Schema(description = "상단고정 여부(Y/N)")
    private String topFixed;
    @Schema(description = "등록 관리자 ID")
    private String regMngrId;
    @Schema(description = "수정 관리자 ID")
    private String modMngrId;
    @Schema(description = "등록 시간")
    private String regTime;
    @Schema(description = "수정 시간")
    private String modTime;
    @Schema(description = "업로드 파일명")
    @Column(length = 50)
    private String uploadFile;
    @Schema(description = "업로드 파일 사용 여부")
    private String useUploadFileYn;
    @Schema(description = "적용 일자")
    private String applyDate;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "f")
    private CommonFile commonFile;

}
