package com.sias.spring_ai_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfiguration  implements WebMvcConfigurer {//这是浏览器的安全策略，跟是不是本地无关
    //让5173可以访问8081，因为是要在浏览器上做文章遵守规则才用到MvcConfiguration
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                .allowedHeaders("*");


    }
}
