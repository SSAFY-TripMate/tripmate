package com.ssafy.tripmate.mate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateComment {
    private int mateCommentNo;
    private int mateNo;
    private String content;
    private int memberNo;
    private Date createdTime;
}
