package com.hnu.admin.config;

import com.hnu.admin.serlet.MyFilter;
import com.hnu.admin.serlet.MyServlet;
import com.hnu.admin.serlet.MyServletContextListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//(proxyBeanMethods =true ) 保证组件都是单实例的
@Configuration

public class MyRegistConfig {

    @Bean
    public  ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return  new ServletRegistrationBean(myServlet, "/my","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/"));
        return  filterRegistrationBean ;
    }

        @Bean
    public ServletListenerRegistrationBean myListener(){
            MyServletContextListener myServletContextListener =new MyServletContextListener();
            return new ServletListenerRegistrationBean(myServletContextListener);
        }


}
