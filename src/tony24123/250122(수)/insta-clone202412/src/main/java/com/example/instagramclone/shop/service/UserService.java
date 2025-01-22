package com.example.instagramclone.shop.service;

import com.example.instagramclone.exception.ErrorCode;
import com.example.instagramclone.exception.MemberException;
import com.example.instagramclone.jwt.JwtTokenProvider;
import com.example.instagramclone.shop.config.PasswordEncoderConfig;
import com.example.instagramclone.shop.repository.UserRepository;
import com.example.instagramclone.shop.user.MeResponse;
import com.example.instagramclone.shop.user.User;
import com.example.instagramclone.shop.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    //유저 생성
    public void createUser(User user) {
        userRepository.insert(user);
    }

    //유저 조회
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

    //로그인된 유저 조회
    @Transactional(readOnly = true)
    public MeResponse currentLoggedInUser(String username) {
        User foundUser = userRepository.findByUserName(username)
                .orElseThrow(
                        () -> new MemberException(ErrorCode.MEMBER_NOT_FOUND)
        );
        return MeResponse.from(foundUser);
    }

    //전체 유저 조회
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserDto(u))
                .collect(Collectors.toList());
    }

    //회원가입 중간 처리
    public void signUp(signUpRequest signUpRequest) {

        //순수 비밀번호
        String rawPassword = signUpRequest.getNewPassword();
        //암호화된 비밀번호
        String encodedPassword = passwordEncoder.encode(rawPassword);


        //회원정보
        User newUser = signUpRequest.toEntity();
        //암호화된 패스워드로 재설정
        newUser.setPassword(encodedPassword);
        //데이터베이스에 저장
        userRepository.insert(newUser);
    }

    //로그인 처리
    @Transactional(readOnly = true)
    public Map<String, Object> authenticate(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();

        User foundUser = userRepository.findByUserName(username)
                .orElseThrow(
                        () -> new MemberException(ErrorCode.MEMBER_NOT_FOUND, "존재하지 않는 회원입니다.")
                );
        //사용자가 입력한 패스워드와 DB에 저장된 패스워드를 추출
        String inputPassword = loginRequest.getPassword();
        String storedpassword = foundUser.getPassword();

        //암호화된 비번 디코딩해서 비교해야함
        //같으면 true 다르면 false
        if (!passwordEncoder.matches(inputPassword, storedpassword)) {
            throw new MemberException(ErrorCode.INVALID_PASSWORD);
        }

        //로그인 성공했을때 JSON 생성
        return Map.of(
                "message", "로그인에 성공했습니다.",
                "username", foundUser.getUsername(),
                //토큰 발급
                "accessToken", jwtTokenProvider.createAccessToken(username)
        );
    }

    //보유칩 업데이트
    public  void updateGameChips(MeResponse meResponse){
        userRepository.update(meResponse);
    }
}
