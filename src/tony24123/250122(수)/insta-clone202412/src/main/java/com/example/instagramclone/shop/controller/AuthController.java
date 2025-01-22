package com.example.instagramclone.shop.controller;


import com.example.instagramclone.shop.service.LoginRequest;
import com.example.instagramclone.shop.service.UserService;
import com.example.instagramclone.shop.service.signUpRequest;
import com.example.instagramclone.shop.user.User;
import com.example.instagramclone.shop.user.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController("shopAuthController")
@RequestMapping("/api/user/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    //회원가입 요청 받아오기
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid signUpRequest signUpRequest){
        log.info("request for signup : {}", signUpRequest.getNewName());
        userService.signUp(signUpRequest);

        return ResponseEntity
                .ok()
                .body("user registered!");
    }

    //로그인 요청 받아오기
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody @Valid LoginRequest loginRequest
            , HttpServletResponse response
    ){
        Map<String, Object> responseMap = userService.authenticate(loginRequest);

        //로그인 성공시 클라이언트에게 두가지 인증 정보를 전달한다.

        //1. API요청을 위한 토큰 정보를 JSON에 담아 전달하고
        //2. 두번째는 페이지 라우팅 요청을 위한 쿠키를 구워서 전달해야 함.
        Cookie cookie = new Cookie("accessToken", (String) responseMap.get("accessToken"));
        //쿠키의 수명 , 사용경로 , 보안 등을 설정
        cookie.setMaxAge(60 * 60); //단위 : 초
        cookie.setPath("/bj");
        cookie.setHttpOnly(true); //보안설정 - 자바스크립트에서 쿠키에 접근 불가

        //쿠키를 클라이언트에게 전송
        response.addCookie(cookie);

        return ResponseEntity.ok().body(responseMap);
    }

//    //회원 생성(DB에 패스워드 암호화 X)
//    @PostMapping
//    public String  create(@RequestBody User user) {
//        userService.createUser(user);
//        return "insert success";
//    }
//
//    //회원 한명 조회
//    @GetMapping("/{id}")
//    public User getUser(@PathVariable Long id) {
//        return userService.getUser(id);
//    }
//
//    //회원 전체 조회
//    @GetMapping
//    public ResponseEntity<List<UserDto>> getAllUser() {
//        List<UserDto> users = userService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
//    //전체 회원 조회
//    @GetMapping("/getall")
//    public ResponseEntity<?> UserList() {
//        List<UserDto> users = new ArrayList<>(userService.getAllUsers());
//        return ResponseEntity.ok().body(users);
//    }

////    @PostMapping("/register")
////public String  createUser(@RequestBody User user) {
////    userService.createUser(user);
////    return "insert success";
//}
}
