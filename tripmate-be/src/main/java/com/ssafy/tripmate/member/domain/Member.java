package com.ssafy.tripmate.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    private int memberNo;
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String gender;
    private Date birth;
    private Date createdTime;
    private String token;
}
