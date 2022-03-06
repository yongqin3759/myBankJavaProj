package com.yongqin.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yongqin.mybank.ApplicationLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
public class Application {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}