package com.ssafy.tripmate.member.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String id;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
