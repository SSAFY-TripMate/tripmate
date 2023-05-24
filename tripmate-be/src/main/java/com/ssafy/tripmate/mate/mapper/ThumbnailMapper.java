package com.ssafy.tripmate.mate.mapper;

import com.ssafy.tripmate.mate.domain.ThumbnailDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface ThumbnailMapper {
    public int write(ThumbnailDto thumbnailDto) throws SQLException;
    public int modify(ThumbnailDto thumbnailDto) throws SQLException;
    public ThumbnailDto findByThumbnailNo(int thumbnailNo) throws SQLException;
}

