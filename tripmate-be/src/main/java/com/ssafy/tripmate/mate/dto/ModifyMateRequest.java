package com.ssafy.tripmate.mate.dto;

import com.ssafy.tripmate.mate.domain.ThumbnailDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ModifyMateRequest {
    private Integer mateNo;
    private Integer sidoCode;
    private String startDate;
    private String endDate;
    private Integer preferenceNo;
    private Integer capacity;
    private String contact;
    private String title;
    private String content;
    private ThumbnailDto thumbnail;
}
