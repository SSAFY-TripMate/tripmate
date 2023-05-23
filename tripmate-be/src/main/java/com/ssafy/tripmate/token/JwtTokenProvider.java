package com.ssafy.tripmate.token;

import com.ssafy.tripmate.member.dto.AuthMember;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider implements TokenManager {


    private static final long ACCESS_TOKEN_VALIDITY = 60 * 60 * 1000;
    private static final long REFRESH_TOKEN_VALIDITY = 30 * 24 * 60 * 60 * 1000;
    private static final String secretKey = "tmEANHrP0oW5q9cFxVhO63MSaIl8GKJYyv7TnXBfdLB";
    private final Key signingKey;

    public JwtTokenProvider() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        this.signingKey = Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String createAccessToken(AuthMember authMember) {
        // Access Token 만료 시간 설정
        Date expirationDate = new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY);

        // Access Token 생성
        return Jwts.builder()
                .claim("memberNo", authMember.getMemberNo())
                .claim("id", authMember.getId())
                .claim("nickname", authMember.getNickname())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();
    }

    @Override
    public String createRefreshToken() {
        // Refresh Token 만료 시간 설정
        Date expirationDate = new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALIDITY);

        // Refresh Token 생성
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();
    }

    @Override
    public AuthMember getParsedClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // parseClaimsJws를 통해 만료된 토큰이면 ExpiredJwtException 예외 발생
        } catch (ExpiredJwtException e) {
            int memberNo = e.getClaims().get("memberNo", Integer.class);
            String id = e.getClaims().get("id", String.class);
            String nickname = e.getClaims().get("nickname", String.class);
            return new AuthMember(memberNo, id, nickname);
        }

        int memberNo = claims.get("memberNo", Integer.class);
        String id = claims.get("id", String.class);
        String nickname = claims.get("nickname", String.class);
        return new AuthMember(memberNo, id, nickname);
    }

    @Override
    public boolean isValid(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
