package com.ssafy.tripmate.member.controller;

import com.ssafy.tripmate.member.domain.Member;
import com.ssafy.tripmate.member.dto.LoginRequest;
import com.ssafy.tripmate.member.dto.AuthMember;
import com.ssafy.tripmate.member.service.MemberService;
import com.ssafy.tripmate.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping("/members")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;
    private final TokenManager tokenManager;

    @Autowired
    public MemberController(MemberService memberService, TokenManager tokenManager) {
        this.memberService = memberService;
        this.tokenManager = tokenManager;
    }

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody Member member) throws SQLException {
        memberService.join(member);
        logger.debug("회원가입 성공");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest loginRequest) throws SQLException {
        logger.debug("로그인 API 호출");

        AuthMember authMember = memberService.login(loginRequest);
        String accessToken = tokenManager.createAccessToken(authMember);
//        String refreshToken = tokenManager.createRefreshToken();
        
//        memberService.saveToken(accessToken, authMember.getId());

        logger.debug("로그인 성공");
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, accessToken)
                .build();
    }

    @DeleteMapping("{memberNo}")
    public ResponseEntity<Void> delete(@PathVariable int memberNo) throws SQLException {
        System.out.println(memberNo);
        memberService.deleteMember(memberNo);

        return ResponseEntity.noContent().build();
    }

}
