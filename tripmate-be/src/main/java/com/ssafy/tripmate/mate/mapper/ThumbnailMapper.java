package com.ssafy.tripmate.mate.mapper;

import com.ssafy.tripmate.mate.domain.ThumbnailDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface ThumbnailMapper {
    public int write(ThumbnailDto thumbnailDto) throws SQLException;
}

