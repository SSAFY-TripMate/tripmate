package com.ssafy.tripmate.mate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.tripmate.mate.domain.MateDto;
import com.ssafy.tripmate.mate.dto.ModifyMateRequest;
import com.ssafy.tripmate.mate.service.MateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/mate")
@CrossOrigin("*")
public class MateController {
    private static final Logger logger = LoggerFactory.getLogger(MateController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final MateService mateService;

    @Autowired
    public MateController(MateService mateService) {
        this.mateService = mateService;
    }

//    @GetMapping("/list")
//    private ResponseEntity<List<MateDto>> list() throws SQLException {
//        return new ResponseEntity<>(mateService.findAll(), HttpStatus.OK);
//    }

//    @GetMapping("/{mateno}")
//    private ResponseEntity<MateDto> getMate(@PathVariable("mateno") int mateno) throws SQLException {
//        return new ResponseEntity<>(mateService.findByMateno(mateno), HttpStatus.OK);
//    }

    @PostMapping(value="", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> writeMate(@RequestParam("mate") String mate, @RequestParam(value="thumbnail", required = false) MultipartFile file) throws Exception {
        logger.info("writeMate - 호출");

        ObjectMapper objectMapper = new ObjectMapper();
        MateDto mateDto = objectMapper.readValue(mate, MateDto.class);

        if (mateService.write(mateDto, file)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

//    @PutMapping("")
//    public ResponseEntity<String> modifyMate(@RequestBody ModifyMateRequest modifyMateRequest) throws Exception {
//        logger.info("modifyMate - 호출"+modifyMateRequest.toString());
//        if (mateService.modifyMate(modifyMateRequest)) {
//            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//        }
//        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping("/{mateno}")
//    private ResponseEntity<String> deleteMate(@PathVariable("mateno") int mateno){
//        try {
//            int res = mateService.deleteMate(mateno);
//            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//        }catch (Exception e){
//            return exceptionHandling(e);
//        }
//    }


    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
