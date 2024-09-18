package com.parquimetro.app.parquimetroapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parquimetro.app.parquimetroapp.domain.parquimetro.gateway.ParquimetroGateway;
import com.parquimetro.app.parquimetroapp.infrastructure.gateway.ParquimetroGatewayImpl;
import com.parquimetro.app.parquimetroapp.infrastructure.persistence.repository.*;

@Configuration
public class GatewayConfig {

    @Bean
    ParquimetroGateway parquimetroGateway(final IParquimetroRepository parquimetroJPARepository) {
        return new ParquimetroGatewayImpl(parquimetroJPARepository);
    }    
}
