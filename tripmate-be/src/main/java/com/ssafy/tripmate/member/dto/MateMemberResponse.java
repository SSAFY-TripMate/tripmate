package com.ssafy.tripmate.member.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MateMemberResponse {
    private String nickname;
    private String birth;
    private String gender;
}
