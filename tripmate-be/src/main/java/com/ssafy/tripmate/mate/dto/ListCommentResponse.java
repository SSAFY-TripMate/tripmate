package com.ssafy.tripmate.mate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCommentResponse {
    private int mateCommentNo;
    private int MateNo;
    private String content;
    private int memberNo;
    private String createdTime;
    private Member member;
    private boolean isAuthor;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Member {
        private String nickname;
        private Date birth;
        private String gender;
    }

}
