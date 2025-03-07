package com.pagecounter.config;

import com.pagecounter.service.PageCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageCountConfig {
    @Bean
    public PageCounter pageCounter() {
        return new PageCounter();
    }
}