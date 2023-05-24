package com.ssafy.tripmate.mate.util;

import com.ssafy.tripmate.mate.domain.ThumbnailDto;
import com.ssafy.tripmate.mate.dto.ListMateResponse;
import com.ssafy.tripmate.mate.dto.ModifyMateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileHandler {
    @Value("${resource.imgPath}")
    private String resourcePath;
    public ThumbnailDto parseFileInfo(Integer mateNo, MultipartFile multipartFile) throws Exception {

        // 파일이 빈 것이 들어오면 빈 것을 반환
        if (multipartFile == null) {
            return null;
        }

        // 파일 이름을 업로드 한 날짜로 바꾸어서 저장할 것이다
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        // 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (Window 의 Tomcat 은 Temp 파일을 이용한다)
//        String absolutePath = new File("").getAbsolutePath() + "\\";

        // 경로를 지정하고 그곳에다가 저장할 심산이다
        String path = resourcePath+"/"+current_date;
        File file = new File(path);
        // 저장할 위치의 디렉토리가 존지하지 않을 경우
        if (!file.exists()) {
            // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
            file.mkdirs();
        }

        // jpeg, png, gif 파일들만 받아서 처리할 예정
        String contentType = multipartFile.getContentType();
        String originalFileExtension;
        // 확장자 명이 없으면 이 파일은 잘 못 된 것이다
        if (ObjectUtils.isEmpty(contentType)) {
            return null;
        } else {
            if (contentType.contains("image/jpeg")) {
                originalFileExtension = ".jpg";
            } else if (contentType.contains("image/jpg")) {
                originalFileExtension = ".jpg";
            }
            else if (contentType.contains("image/png")) {
                originalFileExtension = ".png";
            } else if (contentType.contains("image/gif")) {
                originalFileExtension = ".gif";
            }
            // 다른 파일 명이면 아무 일 하지 않는다
            else {
                return null;
            }
        }
        // 각 이름은 겹치면 안되므로 나노 초까지 동원하여 지정
        String new_file_name = Long.toString(System.nanoTime()) + originalFileExtension;
        // 생성 후 리스트에 추가
        ThumbnailDto thumbnail = new ThumbnailDto();
        thumbnail.setMateNo(mateNo);
        thumbnail.setImageFolder(current_date);
        thumbnail.setImageOriginName(multipartFile.getOriginalFilename());
        thumbnail.setImageSaveName(new_file_name);
        thumbnail.setImageType(originalFileExtension);

        // 저장된 파일로 변경하여 이를 보여주기 위함
        file = new File(path + "/" + new_file_name);
        multipartFile.transferTo(file);

        return thumbnail;
    }

    public void setMateData(ListMateResponse mate, String rootPath){
        mate.setContent(parseTextarea(mate.getContent()));
        if(mate.getThumbnail().getImageFolder()==null ||mate.getThumbnail().getImageFolder()=="") {
            mate.setThumbnailUrl(rootPath+File.separator+"images"+File.separator+"default.png");
            return;
        }
        mate.setThumbnailUrl(rootPath+File.separator+"images"+File.separator+mate.getThumbnail().getImageFolder() + File.separator + mate.getThumbnail().getImageSaveName());

//        for(ListMateResponse mate:list) {
//            if(mate.getThumbnail().getImageFolder()==null || mate.getThumbnail().getImageSaveName()==null) continue;
//            String path=mate.getThumbnail().getImageFolder() + File.separator + mate.getThumbnail().getImageSaveName();
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!"+path);
//            // 이미지 파일 로드
//            ClassPathResource resource = new ClassPathResource(path);
//            if(resource==null) continue;
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!"+resource);
//            InputStream inputStream = resource.getInputStream();
//
//            // 이미지를 Base64로 인코딩
//            byte[] imageBytes = IOUtils.toByteArray(inputStream);
//            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//            mate.setThumbnailFile(base64Image);
//        }
    }
    public String parseTextarea(String origin){
        return origin.replaceAll("/<br/>/g","\r\n");
    }

    public boolean deleteFile(ThumbnailDto deleteThumbnail) throws Exception {
        if (deleteThumbnail == null||deleteThumbnail.getImageSaveName().equals("default")) return true;

        String path = resourcePath+File.separator+deleteThumbnail.getImageFolder()+File.separator+deleteThumbnail.getImageSaveName();
        File file = new File(path);

        if(file.exists()) { // 파일이 존재하면
            file.delete(); // 파일 삭제
        }

        return true;
    }
}
