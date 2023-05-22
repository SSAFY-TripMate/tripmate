package com.ssafy.tripmate.member.service;

import com.ssafy.tripmate.member.domain.Member;
import com.ssafy.tripmate.member.dto.LoginRequest;
import com.ssafy.tripmate.member.dto.AuthMember;
import com.ssafy.tripmate.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Optional<Member> findById(String id) throws SQLException {
        return memberMapper.findById(id);
    }

    public void join(Member member) throws SQLException {
        memberMapper.save(member);
    }

    public AuthMember login(LoginRequest loginRequest) throws SQLException {
        System.out.println(loginRequest.getId());
        Member member = memberMapper.findByIdAndPassword(loginRequest.getId(), loginRequest.getPassword())
                .orElseThrow(NullPointerException::new);
        return new AuthMember(member.getMemberNo(), member.getId(), member.getPassword(), member.getNickname());

    }


}
