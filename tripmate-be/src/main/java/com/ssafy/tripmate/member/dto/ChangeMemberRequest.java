package com.ssafy.tripmate.member.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeMemberRequest {
    private int memberNo;
    private String nickname;
    private String password;
}
