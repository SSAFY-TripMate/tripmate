package com.ssafy.tripmate.area.controller;

import com.ssafy.tripmate.area.domain.Sido;
import com.ssafy.tripmate.area.service.AreaService;
import com.ssafy.tripmate.mate.controller.MateController;
import com.ssafy.tripmate.mate.dto.PageMateResponse;
import com.ssafy.tripmate.mate.service.MateService;
import com.ssafy.tripmate.util.PageNavigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    private static final Logger logger = LoggerFactory.getLogger(MateController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService){
        this.areaService=areaService;
    }

    @GetMapping("/sidos")
    private ResponseEntity<List<Sido>> list() throws SQLException, IOException {

        return new ResponseEntity<>(areaService.findAll(), HttpStatus.OK);
    }
}
