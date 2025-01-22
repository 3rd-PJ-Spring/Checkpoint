package com.example.instagramclone.shop.controller;


import com.example.instagramclone.shop.repository.UserRepository;
import com.example.instagramclone.shop.service.LoginRequest;
import com.example.instagramclone.shop.service.UserService;
import com.example.instagramclone.shop.service.signUpRequest;
import com.example.instagramclone.shop.user.MeResponse;
import com.example.instagramclone.shop.user.User;
import com.example.instagramclone.shop.user.UserDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원 한명 조회
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    //회원 전체 조회
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //전체 회원 조회
    @GetMapping("/getall")
    public ResponseEntity<?> UserList() {
        List<UserDto> users = new ArrayList<>(userService.getAllUsers());
        return ResponseEntity.ok().body(users);
    }

    //로그인한 유저의 정보 조회
    @GetMapping("/currentUser")
    public ResponseEntity<MeResponse> getCurrentUser(
            @AuthenticationPrincipal String username
    ) {
        MeResponse responseDto = userService.currentLoggedInUser(username);

        return ResponseEntity.ok().body(responseDto);
    }

    //보유칩 업데이트
    @PutMapping("/updateChips")
    public  ResponseEntity<?> updateUserChips(
            @RequestBody @Valid MeResponse meResponse
    ){
        userService.updateGameChips(meResponse);
        return ResponseEntity
                .ok()
                .body("chips Update!");
    }
}
