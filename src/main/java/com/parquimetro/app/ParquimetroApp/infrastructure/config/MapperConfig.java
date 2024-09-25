package com.parquimetro.app.ParquimetroApp.infrastructure.config;

import com.parquimetro.app.ParquimetroApp.infrastructure.mapper.ParquimetroMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    ParquimetroMapper parquimetroMapper() {
        return new ParquimetroMapper();
    }
}
