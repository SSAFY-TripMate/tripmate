package com.ssafy.tripmate.mate.mapper;


import com.ssafy.tripmate.mate.domain.MateComment;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface MateCommentMapper {

    List<MateComment> findAll(int mateId) throws SQLException;
    void save(MateComment mateComment) throws SQLException;
    void delete(int commentId) throws  SQLException;

}
