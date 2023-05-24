package com.ssafy.tripmate.member.service;

import com.ssafy.tripmate.member.domain.Member;
import com.ssafy.tripmate.member.dto.LoginRequest;
import com.ssafy.tripmate.member.dto.AuthMember;
import com.ssafy.tripmate.member.mapper.MemberMapper;
import com.ssafy.tripmate.token.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final JwtTokenProvider jwtTokenProvider;
    @Autowired
    public MemberService(MemberMapper memberMapper, JwtTokenProvider jwtTokenProvider) {
        this.memberMapper = memberMapper;
        this.jwtTokenProvider = jwtTokenProvider;
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
        return new AuthMember(member.getMemberNo(), member.getId(), member.getNickname());

    }


    public void saveToken(String token, String id) throws SQLException {
        memberMapper.saveToken(token, id);
    }

    public void deleteToken(String id) throws SQLException {
        memberMapper.deleteToken(id);
    }

    public AuthMember getAuthMember(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null)
            return null;
        return jwtTokenProvider.getParsedClaims(token);
    }
}
