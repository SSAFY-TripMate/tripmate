package com.ssafy.tripmate.mate.controller;

import com.ssafy.tripmate.mate.domain.MateComment;
import com.ssafy.tripmate.mate.domain.Preference;
import com.ssafy.tripmate.mate.dto.ListCommentResponse;
import com.ssafy.tripmate.mate.dto.ListMateResponse;
import com.ssafy.tripmate.mate.dto.ModifyMateRequest;
import com.ssafy.tripmate.mate.dto.PageMateResponse;
import com.ssafy.tripmate.mate.service.MateCommentService;
import com.ssafy.tripmate.mate.service.MateService;
import com.ssafy.tripmate.member.dto.AuthMember;
import com.ssafy.tripmate.member.service.MemberService;
import com.ssafy.tripmate.token.JwtTokenProvider;
import com.ssafy.tripmate.util.PageNavigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/mates")
public class MateController {
    private static final Logger logger = LoggerFactory.getLogger(MateController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final MateService mateService;
    private final MateCommentService mateCommentService;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberService memberService;

    @Autowired
    public MateController(MateService mateService, MateCommentService mateCommentService, JwtTokenProvider jwtTokenProvider, MemberService memberService) {
        this.mateService = mateService;
        this.mateCommentService = mateCommentService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.memberService = memberService;
    }

    @GetMapping("")
    private ResponseEntity<PageMateResponse> list(HttpServletRequest request, PageNavigation pageNav) throws SQLException, IOException {
        String rootPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();

        return new ResponseEntity<>(mateService.findAll(rootPath, pageNav, memberService.getAuthMember(request)), HttpStatus.OK);
    }

    @GetMapping("/{mateNo}")
    private ResponseEntity<ListMateResponse> getMate(HttpServletRequest request, @PathVariable("mateNo") int mateNo) throws SQLException {
        String rootPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

        return new ResponseEntity<>(mateService.findByMateNo(rootPath, mateNo, memberService.getAuthMember(request)), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> writeMate(HttpServletRequest request, @RequestParam("mate") String mate, @RequestParam(value = "thumbnail", required = false) MultipartFile file) throws Exception {
        logger.info("writeMate - 호출");

        if (mateService.write(mate, file, memberService.getAuthMember(request))) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{mateNo}", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> modifyMate(@RequestParam("mate") String mate, @RequestParam(value="thumbnail", required = false) MultipartFile file) throws Exception {
        logger.info("modifyMate - 호출" );
        if (mateService.modifyMate(mate, file)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{mateNo}")
    private ResponseEntity<String> deleteMate(@PathVariable("mateNo") int mateNo){
        try {
            int res = mateService.deleteMate(mateNo);
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }catch (Exception e){
            return exceptionHandling(e);
        }
    }

    @GetMapping("{mateNo}/comments")
    public ResponseEntity<List<ListCommentResponse>> getComment(HttpServletRequest request, @PathVariable int mateNo) throws SQLException {
        List<ListCommentResponse> listCommentResponse = mateCommentService.findAll(mateNo, memberService.getAuthMember(request));
        return new ResponseEntity<>(listCommentResponse, HttpStatus.OK);
    }

    @PostMapping("{mateNo}/comments")
    public ResponseEntity<Void> writeComment(@PathVariable int mateNo, @RequestBody MateComment mateComment, HttpServletRequest request) throws SQLException {
        AuthMember authMember = memberService.getAuthMember(request);

        mateComment.setMemberNo(authMember.getMemberNo());
        mateCommentService.save(mateComment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{mateNo}/comments/{commentNo}")
    public ResponseEntity<Void> deleteComment(@PathVariable int mateNo, @PathVariable int commentNo) throws SQLException {
        System.out.println(commentNo);
        mateCommentService.deleteById(commentNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/preferences")
    private ResponseEntity<List<Preference>> preferenceList() throws SQLException {
        return new ResponseEntity<>(mateService.findAllPreference(), HttpStatus.OK);
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
