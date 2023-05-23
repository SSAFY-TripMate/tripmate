package com.ssafy.tripmate.mate.service;

import com.ssafy.tripmate.mate.domain.MateComment;
import com.ssafy.tripmate.mate.mapper.MateCommentMapper;
import com.ssafy.tripmate.mate.mapper.MateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MateCommentService {

    MateCommentMapper mateCommentMapper;

    @Autowired
    public MateCommentService(MateCommentMapper mateCommentMapper) {
        this.mateCommentMapper = mateCommentMapper;
    }

    List<MateComment> findAll(int mateId) throws SQLException {
        return mateCommentMapper.findAll(mateId);
    }

    void save(MateComment mateComment) throws SQLException {
        mateCommentMapper.save(mateComment);
    }

    void delete(int commentId) throws  SQLException{
        mateCommentMapper.delete(commentId);
    }

}
