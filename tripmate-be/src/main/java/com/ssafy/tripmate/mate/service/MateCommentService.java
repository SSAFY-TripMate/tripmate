package com.ssafy.tripmate.mate.service;

import com.ssafy.tripmate.mate.domain.MateComment;
import com.ssafy.tripmate.mate.dto.ListCommentResponse;
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

    public List<ListCommentResponse> findAll(int mateNo) throws SQLException {
        return mateCommentMapper.findAll(mateNo);
    }

    public void save(MateComment mateComment) throws SQLException {
        mateCommentMapper.save(mateComment);
    }

    public void deleteById(int commentNo) throws SQLException {
        mateCommentMapper.deleteById(commentNo);
    }

}
