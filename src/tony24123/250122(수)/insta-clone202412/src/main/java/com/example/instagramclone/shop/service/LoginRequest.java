package com.example.instagramclone.shop.service;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    @NotBlank(message = "아이디 입력은 필수입니다.")
    private String username;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    private String password;
}
