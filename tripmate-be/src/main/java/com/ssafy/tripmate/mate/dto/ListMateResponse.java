package com.ssafy.tripmate.mate.dto;

import com.ssafy.tripmate.mate.domain.MateDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@RequiredArgsConstructor
public class ListMateResponse extends MateDto {
    // todo: member 객체 추가 
    // private Member member;

    private String thumbnailUrl;
}
