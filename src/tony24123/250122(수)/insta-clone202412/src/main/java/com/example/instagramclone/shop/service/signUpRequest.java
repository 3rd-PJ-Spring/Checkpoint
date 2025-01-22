package com.example.instagramclone.shop.service;

import com.example.instagramclone.shop.user.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//클라이언트로부터 온 요청
public class signUpRequest {
    @NotBlank(message = "필수 입력창입니다.")
    private String newName;

    @NotBlank(message = "필수 입력창입니다.")
    private String newEmail;

    @NotBlank(message = "필수 입력창입니다.")
    private String newPassword;

    //엔터티로 변환
    public User toEntity() {
        return User.builder()
                .email(this.newEmail)
                .password(this.newPassword)
                .username(this.newName)
                .build();
    }

}
