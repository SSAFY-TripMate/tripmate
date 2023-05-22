package com.ssafy.tripmate.member.mapper;

import com.ssafy.tripmate.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<Member> findById(String id) throws SQLException;
    void save(Member member) throws SQLException;
}
