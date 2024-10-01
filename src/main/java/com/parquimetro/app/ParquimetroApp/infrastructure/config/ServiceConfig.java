package com.parquimetro.app.ParquimetroApp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.ParquimetroGateway;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.TicketParquimetroGateway;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;

@Configuration
public class ServiceConfig {

    @Bean
    ParquimetroDomainService parquimetroDomainService(final ParquimetroGateway parquimetroGateway) {
        return new ParquimetroDomainService(parquimetroGateway);
    }
    
    @Bean
    TicketParquimetroDomainService ticketParquimetroDomainService(final TicketParquimetroGateway ticketParquimetroGateway) {
        return new TicketParquimetroDomainService(ticketParquimetroGateway);
    }

}
