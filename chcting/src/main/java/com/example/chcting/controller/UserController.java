package com.example.chcting.controller;


import com.example.chcting.dto.SignupRequestDto;
import com.example.chcting.dto.UserInfoDto;
import com.example.chcting.security.UserDetailsImpl;
import com.example.chcting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 회원 로그인 페이지
    @GetMapping("/user/loginView")
    public String login() {
        return "/login";
    }


    @GetMapping("/user/login/error")
    public String loginError() {
        return "login";
    }


    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("user/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupRequestDto requestDto) {
        System.out.println(requestDto);
        userService.registerUser(requestDto);
        System.out.println("회원가입 완료");
        return ResponseEntity.ok()
                .body("회원가입 완료");
    }

    // 회원 관련 정보 받기
    @PostMapping("/user/userinfo")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUser().getUsername();
        String nickname = userDetails.getUser().getNickname();
        return new UserInfoDto(username, nickname);
    }
}