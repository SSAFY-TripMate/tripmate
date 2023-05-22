package com.ssafy.tripmate.member.controller;

import com.ssafy.tripmate.member.domain.Member;
import com.ssafy.tripmate.member.dto.LoginRequest;
import com.ssafy.tripmate.member.dto.MemberInfo;
import com.ssafy.tripmate.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/members")
@CrossOrigin("*")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody Member member) throws SQLException {
        memberService.join(member);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/login")
    public ResponseEntity<Optional<Member>> login(@Valid @RequestBody LoginRequest loginRequest) throws SQLException {
        MemberInfo memberInfo = memberService.login(loginRequest);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
