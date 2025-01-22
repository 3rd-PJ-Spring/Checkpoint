package com.spring.example.postproject.repository;

import com.spring.example.postproject.domain.member.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberRepository {

    // 회원정보 생성
    void insertMember(Member member);

    // 중복 체크용 조회 메서드
    Optional<Member> findByEmail(String email);
    Optional<Member> findByUsername(String username);


}
