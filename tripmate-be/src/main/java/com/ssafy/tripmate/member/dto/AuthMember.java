package com.ssafy.tripmate.member.dto;

import lombok.Getter;

@Getter
public class AuthMember {

    private int memberNo;
    private String id;
    private String password;
    private String nickname;

    public AuthMember(int memberNo, String id, String password, String nickname) {
        this.memberNo = memberNo;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
}
