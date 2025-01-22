package com.spring.example.postproject.service;

import com.spring.example.postproject.domain.member.dto.request.LoginRequest;
import com.spring.example.postproject.domain.member.dto.request.SignUpRequest;
import com.spring.example.postproject.domain.member.dto.response.DuplicateCheckResponse;
import com.spring.example.postproject.domain.member.entity.Member;
import com.spring.example.postproject.exception.ErrorCode;
import com.spring.example.postproject.exception.MemberException;
import com.spring.example.postproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public void signUp(SignUpRequest signUpRequest) {

         String rawPassword = signUpRequest.getPassword();
         String encodedPassword = passwordEncoder.encode(rawPassword);

        Member newMember = signUpRequest.toEntity();
        newMember.setPassword(encodedPassword);

        memberRepository.insertMember(newMember);

    }

    // 중복 검사 처리
    public DuplicateCheckResponse checkDuplicate(String type, String value) {
        value = value.trim();
        switch (type) {
            case "email":
                return memberRepository.findByEmail(value)
                        .map(m -> DuplicateCheckResponse.unavailable("이미 사용 중인 이메일입니다."))
                        .orElse(DuplicateCheckResponse.available());

                case "username":
                    return memberRepository.findByUsername(value)
                            .map(m -> DuplicateCheckResponse.unavailable("이미 사용 중인 별명입니다."))
                            .orElse(DuplicateCheckResponse.available());

                    default:
                throw new MemberException(ErrorCode.INVALID_SIGNUP_DATA);



        }
    }

    // 로그인 처리(인증처리)
        @Transactional(readOnly = true)
        public Map<String, Object> authenticate(LoginRequest loginRequest) {
            String username = loginRequest.getUsername();
            Member foundMember = memberRepository.findByEmail(username)
                    .orElseThrow(
                            () -> new MemberException(ErrorCode.MEMBER_NOT_FOUND, "존재하지 않는 회원입니다.")
                    ); // 조회가 실패했다면 예외 발생
            // 사용자가 입력한 패스워드와 DB에 저장된 패스워드를 추출
            String inputPassword = loginRequest.getPassword();
            String storedPassword = foundMember.getPassword();
            // 비번이 일치하지 않으면 예외 발생
            // 암호화된 비번을 디코딩해서 비교해야 함
            if (!passwordEncoder.matches(inputPassword, storedPassword)) {
                throw new MemberException(ErrorCode.INVALID_PASSWORD);
            }
            // 로그인이 성공했을 때 JSON 생성
            return Map.of(
                    "message", "로그인에 성공했습니다.",
                    "username", foundMember.getUsername()
            );
        }


}



