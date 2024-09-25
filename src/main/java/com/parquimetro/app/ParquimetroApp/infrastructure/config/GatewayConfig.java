package com.parquimetro.app.ParquimetroApp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.ParquimetroGateway;
import com.parquimetro.app.ParquimetroApp.infrastructure.gateway.ParquimetroGatewayImpl;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository.*;

@Configuration
public class GatewayConfig {

    @Bean
    ParquimetroGateway parquimetroGateway(final IParquimetroRepository parquimetroJPARepository) {
        return new ParquimetroGatewayImpl(parquimetroJPARepository);
    }    
}
