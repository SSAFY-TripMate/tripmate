package com.ssafy.tripmate.member.mapper;

import com.ssafy.tripmate.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<Member> findById(String id) throws SQLException;
    void save(Member member) throws SQLException;

    Optional<Member> findByIdAndPassword(@Param("id") String id, @Param("password") String password) throws SQLException;

    void saveToken(@Param("token") String token, @Param("id") String id) throws SQLException;
    void deleteToken(String id) throws SQLException;

}
