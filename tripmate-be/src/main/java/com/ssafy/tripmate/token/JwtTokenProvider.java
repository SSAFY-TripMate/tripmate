package com.ssafy.tripmate.token;

import com.ssafy.tripmate.member.dto.AuthMember;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider implements TokenManager{
    private static final long ACCESS_TOKEN_VALIDITY = 60 * 60 * 1000;


    @Override
    public String createAccessToken(AuthMember authMember) {
        // 비밀 키 설정
        String secretKey = "qwrjkopjxcopvjpzxcovjpoaiwefjpoiwefksadlfnldasvnkoxczhvohweoqrfsdfdsfszvcasdf";

        // Access Token 만료 시간 설정
        Date expirationDate = new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY);

        // Access Token 생성
        return Jwts.builder()
                .claim("memberNo", authMember.getMemberNo())
                .claim("id", authMember.getId())
                .claim("nickname", authMember.getNickname())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @Override
    public String createRefreshToken() {
        return null;
    }
}
