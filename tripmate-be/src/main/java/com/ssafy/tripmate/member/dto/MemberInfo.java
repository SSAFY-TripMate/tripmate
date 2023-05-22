package com.ssafy.tripmate.member.dto;

import lombok.Getter;

@Getter
public class MemberInfo {

    private String id;
    private String password;

    public MemberInfo(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
