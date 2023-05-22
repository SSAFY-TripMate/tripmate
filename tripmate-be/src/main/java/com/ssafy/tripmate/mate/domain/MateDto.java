package com.ssafy.tripmate.mate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateDto {
    private int mateNo;
    private Integer sidoCode;
    private String startDate;
    private String endDate;
    private Integer preferenceNo;
    private Integer capacity;
    private String contact;
    private String title;
    private String content;
    private int memberNo;
    private int hit;
    private String createdTime;
    private ThumbnailDto thumbnail;
}
