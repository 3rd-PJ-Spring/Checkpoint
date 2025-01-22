package com.example.instagramclone.shop.user;

import lombok.Builder;
import lombok.Getter;

//현재 로그인된 유저 정보 요청 DTO
@Getter
@Builder
public class MeResponse {
    private Long userId;
    private String username;
    private int gameChips;

    public static MeResponse from(User user) {
        return MeResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .gameChips(user.getGameChips())
                .build();
    }
}
