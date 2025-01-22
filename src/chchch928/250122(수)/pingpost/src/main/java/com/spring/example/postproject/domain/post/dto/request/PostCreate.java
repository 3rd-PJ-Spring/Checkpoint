package com.spring.example.postproject.domain.post.dto.request;
import com.spring.example.postproject.domain.post.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
// 피드 생성시 클라이언트가 보낸 JSON데이터를 파싱하고 검증
@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PostCreate {
    @NotBlank(message = "작성자 정보는 필수입니다.")
    private String writer;

    @Size(max = 100, message = "게시판 내용은 최대 100자까지 입력 가능합니다.")
    private String content;

    @Size(max = 20, message = "게시판 제목은 최대 20자까지 입력가능합니다.")
    private String title;


    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .writer(this.writer)
                .content(this.content)
                .build();
    }
}