package com.parquimetro.app.ParquimetroApp.infrastructure.config;

import com.parquimetro.app.ParquimetroApp.infrastructure.mapper.ParquimetroMapper;
import com.parquimetro.app.ParquimetroApp.infrastructure.mapper.TicketParquimetroMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    ParquimetroMapper parquimetroMapper() {
        return new ParquimetroMapper();
    }
    
    @Bean
    TicketParquimetroMapper ticketParquimetroMapper() {
        return new TicketParquimetroMapper();
    }
}
