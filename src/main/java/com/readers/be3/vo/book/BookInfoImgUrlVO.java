package com.readers.be3.vo.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookInfoImgUrlVO { // 책 이미지를 따로 업로드하지 않고 사용하는 경우에 쓸 VO
    @Schema(description = "책 고유번호(입력시엔 null로 입력)")
    private Long biSeq;
    @Schema(description = "제목", example = "아라비안 나이트 5 - 상인 알라딘, 문화")
    private String biName;
    @Schema(description = "저자", example = "그림나무 글.그림, 이희수 감수")
    private String biAuthor;
    @Schema(description = "출판사", example = "기탄출판")
    private String biPublisher;
    @Schema(description = "총 페이지 수", example = "185")
    private Integer biPage;
    @Schema(description = "ISBN", example = "8979592566")
    private String biIsbn;
    @Schema(description = "책 이미지", example = "http://image.aladdin.co.kr/coveretc/book/coversum/8979592566_1.jpg")
    private String bimgUri;
}
