package com.rchores.rchores.config;
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry){
        regstry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
    }

}
