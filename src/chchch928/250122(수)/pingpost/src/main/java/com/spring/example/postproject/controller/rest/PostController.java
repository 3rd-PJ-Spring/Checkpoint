package com.spring.example.postproject.controller.rest;
import com.spring.example.postproject.domain.post.dto.request.PostCreate;
import com.spring.example.postproject.domain.post.entity.Post;
import com.spring.example.postproject.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
@RestController
@RequestMapping("/api/posts")
@Slf4j
@RequiredArgsConstructor
public class PostController{

    private final PostService postService;

    // 피드 목록 조회 요청
    @GetMapping
    public ResponseEntity<?> getAllBoards() {
        List<Post> allBoards = postService.findAllBoards();

        return ResponseEntity.ok().body(allBoards);
    }

    // 피드 생성 요청
    @PostMapping
    public ResponseEntity<?> createBoard(
            @RequestPart("board") @Valid PostCreate postCreate
    ) {
        log.info("board create request: POST - {}", postCreate);

        postService.createBoard(postCreate);

        return ResponseEntity
                .ok()
                .body(null);
    }
}