package com.liveamonth.liveamonth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/summernoteImage/**")
                .addResourceLocations("file:///C:/Users/hjww1/OneDrive - 명지대학교/바탕 화면/STS Workspace/LiveAmonth/src/main/webapp/reviewImageTest/");
    }
}