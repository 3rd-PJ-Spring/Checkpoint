package com.spring.example.postproject.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DuplicateCheckResponse {

    private boolean available; //사용 가능한지 여부
    private String message; // 중복 검사 결과 메세지

    // 사용 가능할 경우 객체생성 메서드
    public static DuplicateCheckResponse available() {
        return DuplicateCheckResponse.builder()
                .available(true)
                .build();
    }

    // 사용 불가능할 경우 객체생성 메서드
    public static DuplicateCheckResponse unavailable(String message) {
        return DuplicateCheckResponse.builder()
                .available(false)
                .message(message)
                .build();
    }
}
