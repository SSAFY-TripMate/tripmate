package com.ssafy.tripmate.interceptor;

import com.ssafy.tripmate.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);
    private final TokenManager tokenManager;

    @Autowired
    public AuthInterceptor(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("인터셉터 IN");

        // 요청 헤더에서 토큰 정보 추출
        String token = request.getHeader("Authorization");
        System.out.println("token : " + token);


        if (CorsUtils.isPreFlightRequest(request)) {
            LOGGER.debug("if request options method is options, return true");
            return true;
        }


        String requestMethod = request.getMethod();
        if (requestMethod.equalsIgnoreCase("GET")) {
            // GET 요청
            return true;
        }

        if (!tokenManager.isValid(token)) {
            // 토큰이 유효하지 않은 경우 예외 처리 또는 인증 실패로 처리
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "권한없음");
            LOGGER.debug("토큰 인증 실패");
            return false;
        }

        // 토큰이 유효한 경우 요청 계속 진행
        LOGGER.debug("토큰 인증 성공");
        return true;
    }


}
