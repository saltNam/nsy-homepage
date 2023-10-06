package com.nsy.homepage.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CommonBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    private String category;
    private String subCategory;
    private String title;
    private String contentText;
    private String contentSub;
    private String contentUrl;
    private long hitCnt;
    private String useYn;
    private String useFrontYn;
    private String delYn;
    private String popupYn;
    private String topFixed;
    private String regMngrId;
    private String modMngrId;
    private String regTime;
    private String modTime;
    private String uploadFile;
    private String useUploadFileYn;
    private String applyDate;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "commonBoard")
    private CommonFile commonFile;

}
