package com.nsy.homepage.domain;

import com.nsy.homepage.controller.dto.request.GetHomepageQuestionDto;
import com.nsy.homepage.converter.EmailConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor
public class HomepageQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "문의하기 순번", example = "1")
    @Column(length = 11)
    private long seq;
    @Schema(description = "등록 시간")
    @Column(length = 14)
    private String regTime;
    @Schema(description = "고객명", example = "남승연")
    @Column(length = 100)
    private String customerName;
    @Schema(description = "고객사명", example = "네이버")
    @Column(length = 100)
    private String companyName;
    @Schema(description = "고객 이메일", example = "seungyeon@welgram.com")
    @Convert(converter = EmailConverter.class)
    private String email;
    @Schema(description = "문의 내용", example = "문의 내용 입니다")
    private String content;
    @Schema(description = "개인정보 수집 및 이용 동의여부", example = "Y")
    @Column(length = 1)
    private String personalInfoAgreeYn;
    @Schema(description = "개인정보 수집 및 이용 기간(년)", example = "1")
    @Column(length = 1)
    private String personalInfoAgreePeriod;

    public static HomepageQuestion createHomepageQuestion(GetHomepageQuestionDto getHomepageQuestionDto) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        HomepageQuestion homepageQuestion = new HomepageQuestion();
        homepageQuestion.regTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        homepageQuestion.customerName = getHomepageQuestionDto.getCustomerName();
        homepageQuestion.companyName = getHomepageQuestionDto.getCompanyName();
        homepageQuestion.email = getHomepageQuestionDto.getEmail();
        homepageQuestion.content = getHomepageQuestionDto.getContent();
        homepageQuestion.personalInfoAgreeYn = getHomepageQuestionDto.getPersonalInfoAgreeYn();
        homepageQuestion.personalInfoAgreePeriod = "1";
        return homepageQuestion;
    }

}
