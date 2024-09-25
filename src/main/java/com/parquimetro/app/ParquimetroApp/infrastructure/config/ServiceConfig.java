package com.parquimetro.app.ParquimetroApp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.ParquimetroGateway;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;

@Configuration
public class ServiceConfig {

    @Bean
    ParquimetroDomainService parquimetroDomainService(final ParquimetroGateway parquimetroGateway) {
        return new ParquimetroDomainService(parquimetroGateway);
    }

}
