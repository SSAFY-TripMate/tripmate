package com.ssafy.tripmate.area.service;

import com.ssafy.tripmate.area.domain.Sido;
import com.ssafy.tripmate.area.mapper.AreaMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AreaService {

    private AreaMapper areaMapper;
    public AreaService(AreaMapper areaMapper){
        this.areaMapper=areaMapper;
    }

    public List<Sido> findAll() throws SQLException {
        return areaMapper.findAll();
    }
}
