package com.ssafy.tripmate.mate.service;

import com.ssafy.tripmate.mate.domain.MateDto;
import com.ssafy.tripmate.mate.domain.ThumbnailDto;
import com.ssafy.tripmate.mate.dto.ModifyMateRequest;
import com.ssafy.tripmate.mate.mapper.MateMapper;
import com.ssafy.tripmate.mate.mapper.ThumbnailMapper;
import com.ssafy.tripmate.mate.util.FileHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class MateService {

    private final MateMapper mateMapper;
    private final ThumbnailMapper thumbnailMapper;
    private final FileHandler fileHandler;

    public MateService(MateMapper mateMapper, ThumbnailMapper thumbnailMapper, FileHandler fileHandler) {
        this.mateMapper = mateMapper;
        this.thumbnailMapper=thumbnailMapper;
        this.fileHandler = fileHandler;
    }

//    public List<MateDto> findAll() throws SQLException {
//        return mateMapper.selectAll();
//    }
//    public MateDto findByMateno(int mateno) throws SQLException {
//        return mateMapper.getMate(mateno);
//    }
    public boolean write(MateDto mateDto, MultipartFile file) throws Exception {
        if (mateDto == null) throw new Exception();

        if(mateDto.getStartDate()=="") mateDto.setStartDate(null);
        if(mateDto.getEndDate()=="") mateDto.setEndDate(null);
        int res=mateMapper.write(mateDto);

        // 파일을 저장하고 그 BoardPicture 에 대한 list 를 가지고 있는다
        ThumbnailDto thumbnailDto=null;
        if(file!=null) {
            thumbnailDto = fileHandler.parseFileInfo(mateDto.getMateNo(), file);
        }

        if(thumbnailDto==null){
            // TODO : 파일이 없을 때
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            res = thumbnailMapper.write(thumbnailDto);
//            board.setPictures(pictureBeans);
        }

        return res == 1;
    }

//    public boolean modifyMate(ModifyMateRequest modifyMateRequest) throws Exception {
//        if (modifyMateRequest == null) throw new Exception();
//        return mateMapper.modifyMate(modifyMateRequest) == 1;
//    }
//
//    public int deleteMate(int mateno) throws SQLException{
//        return mateMapper.deleteMate(mateno);
//    }
}
