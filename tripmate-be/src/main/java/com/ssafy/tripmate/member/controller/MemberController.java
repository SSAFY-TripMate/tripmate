package com.ssafy.tripmate.member.controller;

import com.ssafy.tripmate.member.domain.Member;
import com.ssafy.tripmate.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ResponseEntity<Optional<Member>> login(String id, String password) throws SQLException {
        logger.debug(id + " " + password);
//        Optional<Member> member = memberService.findById(id);
//        logger.debug(String.valueOf(member));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody Member member) throws SQLException {
        memberService.join(member);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
