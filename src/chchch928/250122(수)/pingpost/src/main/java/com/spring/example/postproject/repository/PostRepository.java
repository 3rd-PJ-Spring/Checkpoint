package com.spring.example.postproject.repository;

import com.spring.example.postproject.domain.post.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {
    // 게시물 저장
    void saveBoard (Post post);
    // 게시물 전체목록 조회
    List<Post> findAll();
}
