package com.ssafy.tripmate.mate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.tripmate.mate.domain.MateDto;
import com.ssafy.tripmate.mate.domain.ThumbnailDto;
import com.ssafy.tripmate.mate.dto.ListMateResponse;
import com.ssafy.tripmate.mate.dto.ModifyMateRequest;
import com.ssafy.tripmate.mate.dto.PageMateResponse;
import com.ssafy.tripmate.mate.mapper.MateMapper;
import com.ssafy.tripmate.mate.mapper.ThumbnailMapper;
import com.ssafy.tripmate.mate.util.FileHandler;
import com.ssafy.tripmate.member.dto.AuthMember;
import com.ssafy.tripmate.util.PageNavigation;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Pageable;
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
        this.thumbnailMapper = thumbnailMapper;
        this.fileHandler = fileHandler;
    }

    public PageMateResponse findAll(String rootPath, PageNavigation pageNav) throws SQLException, IOException {
        int start = pageNav.getPg() == 0 ? 0 : (pageNav.getPg() - 1) * pageNav.getSpp();
        pageNav.setStart(start);

        List<ListMateResponse> mates=mateMapper.findAll(pageNav);
        for(ListMateResponse mate:mates) {
            fileHandler.setMateData(mate, rootPath);
        }

        pageNav.setTotal(mateMapper.countAll(pageNav));
        PageMateResponse pageMateResponse = new PageMateResponse(mates, pageNav);
        return pageMateResponse;
    }

    public ListMateResponse findByMateNo(String rootPath, int mateno, AuthMember authMember) throws SQLException {
        ListMateResponse mate = mateMapper.findByMateNo(mateno);
        if (authMember != null && authMember.getMemberNo() == mate.getMemberNo()) mate.setAuthor(true);
        fileHandler.setMateData(mate, rootPath);
        return mate;
    }

    public boolean write(String mate, MultipartFile file, AuthMember authMember) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        MateDto mateDto = objectMapper.readValue(mate, MateDto.class);
        if (mateDto == null) throw new Exception();

        mateDto.setMemberNo(authMember.getMemberNo());

        //textarea안에서 사용할 줄바꿈은 db에 저장할 때 치환을 해야한다 replaceAll이 없어 정규화로 대체
        mateDto.setContent(mateDto.getContent().replaceAll("\r\n", "<br/>"));
        if (mateDto.getStartDate() == "") mateDto.setStartDate(null);
        if (mateDto.getEndDate() == "") mateDto.setEndDate(null);
        int res = mateMapper.write(mateDto);

        // 파일을 저장하고 그 BoardPicture 에 대한 list 를 가지고 있는다
        ThumbnailDto thumbnailDto = null;
        if (file != null) {
            thumbnailDto = fileHandler.parseFileInfo(mateDto.getMateNo(), file);
        }

        if (thumbnailDto == null) {
            // TODO : 파일이 없을 때
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else {
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

    public int deleteMate(int mateNo) throws Exception {
        ThumbnailDto deleteThumbnail = thumbnailMapper.findByThumbnailNo(mateNo);
        if(deleteThumbnail!=null) {
            fileHandler.deleteFile(deleteThumbnail);
            thumbnailMapper.delete(deleteThumbnail.getMateThumbnailNo());
        }
        return mateMapper.deleteMate(mateNo);
    }
}
