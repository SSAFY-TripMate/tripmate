package com.ssafy.tripmate.mate.mapper;

import com.ssafy.tripmate.mate.domain.MateDto;
import com.ssafy.tripmate.mate.dto.ListMateResponse;
import com.ssafy.tripmate.mate.dto.ModifyMateRequest;
import com.ssafy.tripmate.mate.dto.PageMateResponse;
import com.ssafy.tripmate.util.PageNavigation;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface MateMapper {
    public int write(MateDto mateDto) throws SQLException;
    public List<ListMateResponse> findAll(PageNavigation pageNav) throws SQLException;
    public ListMateResponse findByMateNo(int mateNo) throws SQLException;
    public int modifyMate(ModifyMateRequest modifyMateRequest) throws SQLException;
    public int deleteMate(int mateno) throws SQLException;

    public int countAll() throws SQLException;
}

