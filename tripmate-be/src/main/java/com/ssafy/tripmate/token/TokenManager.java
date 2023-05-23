package com.ssafy.tripmate.token;


import com.ssafy.tripmate.member.dto.AuthMember;

public interface TokenManager {
    String createAccessToken(AuthMember authMember);
    String createRefreshToken();
}
