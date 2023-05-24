package com.ssafy.tripmate.mate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.tripmate.mate.domain.MateDto;
import com.ssafy.tripmate.mate.domain.ThumbnailDto;
import com.ssafy.tripmate.mate.dto.ListMateResponse;
import com.ssafy.tripmate.mate.dto.ModifyMateRequest;
import com.ssafy.tripmate.mate.mapper.MateMapper;
import com.ssafy.tripmate.mate.mapper.ThumbnailMapper;
import com.ssafy.tripmate.mate.util.FileHandler;
import com.ssafy.tripmate.member.dto.AuthMember;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Base64;
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

    public List<ListMateResponse> findAll(String rootPath) throws SQLException, IOException {
        List<ListMateResponse> list=mateMapper.findAll();
        for(ListMateResponse mate:list) {
            fileHandler.setMateData(mate, rootPath);
        }
        return list;
    }
    public ListMateResponse findByMateNo(String rootPath, int mateno, AuthMember authMember) throws SQLException {
        ListMateResponse mate=mateMapper.findByMateNo(mateno);
        if(authMember.getMemberNo()==mate.getMemberNo()) mate.setAuthor(true);
        fileHandler.setMateData(mate, rootPath);
        return mate;
    }
    public boolean write(String mate, MultipartFile file, AuthMember authMember) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        MateDto mateDto = objectMapper.readValue(mate, MateDto.class);
        if (mateDto == null) throw new Exception();

        mateDto.setMemberNo(authMember.getMemberNo());

        //textarea안에서 사용할 줄바꿈은 db에 저장할 때 치환을 해야한다 replaceAll이 없어 정규화로 대체
        mateDto.setContent(mateDto.getContent().replaceAll("\r\n","<br/>"));
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

    public boolean modifyMate(String mate, MultipartFile file) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ModifyMateRequest modifyMateRequest = objectMapper.readValue(mate, ModifyMateRequest.class);
        if (modifyMateRequest == null || modifyMateRequest.getMateNo()==null) throw new Exception();

        //textarea안에서 사용할 줄바꿈은 db에 저장할 때 치환을 해야한다 replaceAll이 없어 정규화로 대체
        modifyMateRequest.setContent(modifyMateRequest.getContent().replaceAll("\r\n","<br/>"));
        if(modifyMateRequest.getStartDate()=="") modifyMateRequest.setStartDate(null);
        if(modifyMateRequest.getEndDate()=="") modifyMateRequest.setEndDate(null);

        int res=mateMapper.modifyMate(modifyMateRequest);

        // 파일을 저장
        ThumbnailDto thumbnailDto=null;
        if(file!=null) {
            thumbnailDto = fileHandler.parseFileInfo(modifyMateRequest.getMateNo(), file);
        }
        if(thumbnailDto!=null){
            ThumbnailDto deleteThumbnail = thumbnailMapper.findByThumbnailNo(modifyMateRequest.getThumbnail().getMateThumbnailNo());
            res = thumbnailMapper.modify(thumbnailDto);
            if(res==1) fileHandler.deleteFile(deleteThumbnail);
        }

        return res == 1;
    }
//
//    public int deleteMate(int mateno) throws SQLException{
//        return mateMapper.deleteMate(mateno);
//    }
}
