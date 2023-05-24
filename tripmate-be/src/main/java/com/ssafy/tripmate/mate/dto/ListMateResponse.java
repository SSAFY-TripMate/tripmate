package com.ssafy.tripmate.mate.dto;

import com.ssafy.tripmate.mate.domain.MateDto;
import com.ssafy.tripmate.member.dto.MateMemberResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@RequiredArgsConstructor
public class ListMateResponse extends MateDto {
    private MateMemberResponse member;
    private String thumbnailUrl;
}
