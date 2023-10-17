package com.nsy.homepage.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Schema(description = "문의하기 등록")
public class GetHomepageQuestionDto {
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    @Schema(description = "고객명", nullable = false, example = "홍길동")
    private String customerName;
    @NotBlank(message = "회사명은 필수 입력 값입니다.")
    @Schema(description = "회사명", nullable = false, example = "웰그램")
    private String companyName;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Schema(description = "이메일", nullable = false, example = "test@welgram.com")
    private String email;
    @NotBlank(message = "문의 내용은 필수 입력 값입니다.")
    @Schema(description = "문의 내용", nullable = false, example = "문의하기 테스트 입니다")
    private String content;
    @Pattern(regexp = "^Y+$", message = "개인 정보 동의는 Y 값만 가능합니다.")
    @NotBlank(message = "개인정보 제공 동의를 해주세요.")
    @Schema(description = "개인정보 제공 동의", nullable = false, example = "Y")
    private String personalInfoAgreeYn;
    @Schema(description = "개인정보 제공 동의 기간", nullable = false, example = "1")
    private String personalInfoAgreePeriod;

}
