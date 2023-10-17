package com.nsy.homepage.controller;

import com.nsy.homepage.common.ApiCommonResponse;
import com.nsy.homepage.common.ApiErrorResponse;
import com.nsy.homepage.controller.dto.request.GetHomepageQuestionDto;
import com.nsy.homepage.domain.HomepageQuestion;
import com.nsy.homepage.repository.HomepageQuestionRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Tag(name="Question", description = "문의하기 등록 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomepageQuestionController {

    private final HomepageQuestionRepository homepageQuestionRepository;

    @Operation(summary = "문의하기 등록 API", description = "문의하기를 등록하는 API 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "문의하기 등록 성공 응답입니다.", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "400", description = "Validation 오류입니다.",content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping("/v0.1/question")
    public ResponseEntity<ApiCommonResponse<String>> saveHomepageQuestion(@RequestBody @Valid GetHomepageQuestionDto getHomepageQuestionDto) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        HomepageQuestion homepageQuestion = HomepageQuestion.createHomepageQuestion(getHomepageQuestionDto);
        homepageQuestionRepository.save(homepageQuestion);

        ApiCommonResponse response = ApiCommonResponse.builder()
                .statusCode(200)
                .result("문의가 정상적으로 등록되었어요.")
                .build();

        return ResponseEntity.ok(response);
    }




}
