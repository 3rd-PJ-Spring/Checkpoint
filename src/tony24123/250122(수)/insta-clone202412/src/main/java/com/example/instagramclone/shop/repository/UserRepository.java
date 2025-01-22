package com.example.instagramclone.shop.repository;


import com.example.instagramclone.domain.post.entity.Post;
import com.example.instagramclone.shop.user.MeResponse;
import com.example.instagramclone.shop.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    //아이디 조회
    Optional<User> findByUserName(String username);

    //유저 생성
    void insert(User user);

    //유저 조회
    Optional<User> findById(Long id);

    //전체 유저 조회
    List<User> findAll();

    //보유 칩 업데이트
    void update(MeResponse meResponse);
}
