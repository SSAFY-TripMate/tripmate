package com.ssafy.tripmate.member.service;

import com.ssafy.tripmate.member.domain.Member;
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

}
