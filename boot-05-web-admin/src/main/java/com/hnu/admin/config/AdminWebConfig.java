package com.hnu.admin.config;


import com.hnu.admin.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到指定容器中（实现WebMvcConfigurer的addInterceptors，@Configuration）
 * 3、指定拦截器规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
@Slf4j
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry 就是添加自己的拦截器注册
        registry.addInterceptor( new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/js/**","/css/**","/login/**","/fonts/**","/images/**","/");
        //拦截器里记得放行根路径
    }

}
