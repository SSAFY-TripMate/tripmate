package com.ssafy.tripmate.util;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class PageNavigation {
    private int pg; // 현재 페이지 번호
    private int spp=12; // 페이지당 글 개수
    private int total; // 총 글 개수
    private int start; // 페이지 시작 글 번호
    private String order="mate_no"; // 정렬 조건
    private String word; // 검색어
}
