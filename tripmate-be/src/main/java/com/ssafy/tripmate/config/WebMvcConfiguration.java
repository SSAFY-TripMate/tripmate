package com.ssafy.tripmate.config;

import com.ssafy.tripmate.interceptor.AuthInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
@MapperScan(basePackages = {"com.ssafy.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final List<String> addPaths = Arrays.asList("/members/**", "/mates/**");
    private final List<String> excludePaths = Arrays.asList("/members/login", "/members/join");

    private final AuthInterceptor authInterceptor;
    @Value("${resource.imgPath}")
    private String resourcePath;
    @Value("${upload.imgPath}")
    private String uploadPath;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .exposedHeaders("Authorization")
                .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(uploadPath).addResourceLocations("file:///"+resourcePath+"/");
    }
    
    @Autowired
    public WebMvcConfiguration(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(addPaths)
                .excludePathPatterns(excludePaths);
    }
}
