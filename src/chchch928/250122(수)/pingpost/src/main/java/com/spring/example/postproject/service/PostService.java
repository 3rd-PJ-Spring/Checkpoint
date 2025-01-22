package com.spring.example.postproject.service;

import com.spring.example.postproject.domain.post.dto.request.PostCreate;
import com.spring.example.postproject.domain.post.entity.Post;
import com.spring.example.postproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAllBoards(){
        // 전체 피드 조회
        List<Post> boardList = postRepository.findAll();

        return boardList;
    }

    public void createBoard(PostCreate postCreate){

        Post post = postCreate.toEntity();

        postRepository.saveBoard(post);

    }
}