package com.ssafy.tripmate.mate.dto;

import com.ssafy.tripmate.mate.domain.MateDto;
import com.ssafy.tripmate.member.dto.MateMemberResponse;
import com.ssafy.tripmate.util.PageNavigation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class PageMateResponse{
    private List<ListMateResponse> mates;
    private PageNavigation pageNav;
}
