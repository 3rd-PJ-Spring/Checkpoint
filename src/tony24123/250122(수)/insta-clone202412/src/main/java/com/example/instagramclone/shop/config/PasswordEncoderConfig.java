package com.example.instagramclone.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 //패스워드 암호화
@Configuration
public class PasswordEncoderConfig {

    //Spring에서는 기본적으로 같은 이름의 Bean을 두 번 등록하려 하면 에러 발생
    @Bean(name = "shopPasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
