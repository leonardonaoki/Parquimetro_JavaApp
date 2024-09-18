package com.parquimetro.app.parquimetroapp.infrastructure.config;

import com.parquimetro.app.parquimetroapp.application.parquimetro.usecase.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parquimetro.app.parquimetroapp.domain.parquimetro.service.ParquimetroDomainService;

@Configuration
public class UseCaseConfig {

    @Bean
    CreateParquimetroUseCase createParquimetroUseCase(final ParquimetroDomainService parquimetroDomainService) {
        return new CreateParquimetroUseCase(parquimetroDomainService);
    }

    @Bean
    DeleteParquimetroUseCase deleteParquimetroUseCase(final ParquimetroDomainService parquimetroDomainService) {
        return new DeleteParquimetroUseCase(parquimetroDomainService);
    }

    @Bean
    GetAllParquimetrosUseCase getAllParquimetrosUseCase(final ParquimetroDomainService parquimetroDomainService) {
        return new GetAllParquimetrosUseCase(parquimetroDomainService);
    }

    @Bean
    GetParquimetroByIdUseCase getParquimetroByIdUseCase(final ParquimetroDomainService parquimetroDomainService) {
        return new GetParquimetroByIdUseCase(parquimetroDomainService);
    }
    
    @Bean
    UpdateParquimetroUseCase updateParquimetroUseCase(final ParquimetroDomainService parquimetroDomainService) {
        return new UpdateParquimetroUseCase(parquimetroDomainService);
    }

}
