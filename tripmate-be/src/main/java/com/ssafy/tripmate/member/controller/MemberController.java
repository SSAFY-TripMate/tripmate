package com.ssafy.tripmate.member.controller;

import com.ssafy.tripmate.member.domain.Member;
import com.ssafy.tripmate.member.dto.LoginRequest;
import com.ssafy.tripmate.member.dto.AuthMember;
import com.ssafy.tripmate.member.service.MemberService;
import com.ssafy.tripmate.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/members")
@CrossOrigin("*")
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
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/login")
    public ResponseEntity<Optional<Member>> login(@Valid @RequestBody LoginRequest loginRequest) throws SQLException {
        AuthMember authMember = memberService.login(loginRequest);

        String accessToken = tokenManager.createAccessToken(authMember);
        String refreshToken = tokenManager.createRefreshToken();
        System.out.println("엑세스 : " + accessToken);
        System.out.println("리프레시 : " + refreshToken);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
