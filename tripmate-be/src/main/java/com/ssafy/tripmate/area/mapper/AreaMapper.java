package com.ssafy.tripmate.area.mapper;

import com.ssafy.tripmate.area.domain.Sido;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface AreaMapper {
    public List<Sido> findAll() throws SQLException;
}
