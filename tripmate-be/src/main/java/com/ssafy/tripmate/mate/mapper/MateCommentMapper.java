package com.ssafy.tripmate.mate.mapper;


import com.ssafy.tripmate.mate.domain.MateComment;
import com.ssafy.tripmate.mate.dto.ListCommentResponse;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface MateCommentMapper {

    List<ListCommentResponse> findAll(int mateNo) throws SQLException;
    void save(MateComment mateComment) throws SQLException;
    void deleteById(int commentNo) throws  SQLException;

}
