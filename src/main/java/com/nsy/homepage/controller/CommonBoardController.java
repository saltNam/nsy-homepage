package com.nsy.homepage.controller;

import com.nsy.homepage.common.ApiErrorResponse;
import com.nsy.homepage.common.ApiCommonResponse;
import com.nsy.homepage.controller.dto.request.GetBoardListDto;
import com.nsy.homepage.controller.dto.response.BoardDetailResponseDto;
import com.nsy.homepage.controller.dto.response.BoardListResponseDto;
import com.nsy.homepage.service.CommonBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Board", description = "게시판 관련 api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommonBoardController {

    @Autowired
    CommonBoardService commonBoardService;

    @Operation(summary = "게시판 리스트 조회 API", description = "카테고리 별 게시물 리스트 조회 API 입니다. page, limit, category 파라미터가 존재해야 조회 가능합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @GetMapping("/v0.1/board/{category}")
    public ResponseEntity<ApiCommonResponse<BoardListResponseDto>> getBoardList(@RequestParam int page, @RequestParam int limit, @PathVariable String category) {
        GetBoardListDto getBoardListDto = GetBoardListDto.builder()
                .limit(limit)
                .page(page)
                .build();

        BoardListResponseDto boardList = commonBoardService.getBoardList(getBoardListDto, category);
        ApiCommonResponse response = ApiCommonResponse.builder()
                .statusCode(200)
                .result(boardList)
                .build();

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "게시물 상세 조회 API", description = "카테고리 별 게시물 상세 데이터 조회 API 입니다. category, seq 파라미터가 존재해야 조회 가능합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @GetMapping("/{category}/{seq}")
    public ResponseEntity<ApiCommonResponse<BoardDetailResponseDto>> getBoardDetail(@PathVariable String category, @PathVariable int seq) {
        BoardDetailResponseDto boardDetail = commonBoardService.getBoardDetail(category, seq);

        ApiCommonResponse response = ApiCommonResponse.builder()
                .statusCode(200)
                .result(boardDetail)
                .build();

        return ResponseEntity.ok(response);
    }






}
