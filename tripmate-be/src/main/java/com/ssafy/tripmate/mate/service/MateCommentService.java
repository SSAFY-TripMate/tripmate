package com.ssafy.tripmate.mate.service;

import com.ssafy.tripmate.mate.domain.MateComment;
import com.ssafy.tripmate.mate.dto.ListCommentResponse;
import com.ssafy.tripmate.mate.dto.ListMateResponse;
import com.ssafy.tripmate.mate.mapper.MateCommentMapper;
import com.ssafy.tripmate.mate.mapper.MateMapper;
import com.ssafy.tripmate.member.dto.AuthMember;
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

    public List<ListCommentResponse> findAll(int mateNo, AuthMember authMember) throws SQLException {

        List<ListCommentResponse> comments=mateCommentMapper.findAll(mateNo);
        if (authMember == null) return comments;

        for(ListCommentResponse comment:comments) {
            if (authMember.getMemberNo() == comment.getMemberNo()) comment.setAuthor(true);
        }

        return comments;
    }

    public void save(MateComment mateComment) throws SQLException {
        mateCommentMapper.save(mateComment);
    }

    public void deleteById(int mateCommentNo) throws SQLException {
        mateCommentMapper.deleteById(mateCommentNo);
    }

}
