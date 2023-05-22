package com.ssafy.tripmate.mate.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ModifyMateRequest {
    private int mateNo;
    private Integer sidoCode;
    private String startDate;
    private String endDate;
    private Integer preferenceNo;
    private Integer capacity;
    private String contact;
    private String title;
    private String content;
}
