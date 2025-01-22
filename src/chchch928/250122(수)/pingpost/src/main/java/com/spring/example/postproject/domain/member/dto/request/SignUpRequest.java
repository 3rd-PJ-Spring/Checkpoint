package com.spring.example.postproject.domain.member.dto.request;

import com.spring.example.postproject.domain.member.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotBlank(message = "별명을 입력해주세요")
    private String username;

    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "유효한 이메일 주소를 입력해주세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "비밀번호는 8자 이상, 영문과 숫자 조합이어야 합니다")
    private String password;

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .build();
    }

}
