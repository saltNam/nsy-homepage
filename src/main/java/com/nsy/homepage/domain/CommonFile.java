package com.nsy.homepage.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class CommonFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String fileType;
    private String filePath;
    private String fileName;
    private String orgName;
    private LocalDateTime regTime;
    @OneToOne
    private CommonBoard commonBoard;
}
