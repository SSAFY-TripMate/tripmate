package com.ssafy.tripmate.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthMember {

    private int memberNo;
    private String id;
    private String nickname;

    public AuthMember(int memberNo, String id, String nickname) {
        this.memberNo = memberNo;
        this.id = id;
        this.nickname = nickname;
    }
}
