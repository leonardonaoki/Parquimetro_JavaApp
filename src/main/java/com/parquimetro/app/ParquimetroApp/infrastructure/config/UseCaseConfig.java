package com.parquimetro.app.ParquimetroApp.infrastructure.config;

import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;

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
    
    @Bean
    UpdateSaidaUseCase updateSaidaUseCase(final TicketParquimetroDomainService ticketParquimetroDomainService) {
        return new UpdateSaidaUseCase(ticketParquimetroDomainService);
    }
    
    @Bean
    CreateEntradaUseCase createEntradaUseCase(final TicketParquimetroDomainService ticketParquimetroDomainService) {
        return new CreateEntradaUseCase(ticketParquimetroDomainService);
    }
    
    @Bean
    BuscaDividaCarroUseCase buscaDividaCarroUseCase(final TicketParquimetroDomainService ticketParquimetroDomainService) {
        return new BuscaDividaCarroUseCase(ticketParquimetroDomainService);
    }
    @Bean
    PagarDividaEmAbertoUseCase pagarDividaEmAbertoUseCase(final TicketParquimetroDomainService ticketParquimetroDomainService) {
        return new PagarDividaEmAbertoUseCase(ticketParquimetroDomainService);
    }
    @Bean
    RecebePagamentoUseCase recebePagamentoUseCase(final TicketParquimetroDomainService ticketParquimetroDomainService) {
        return new RecebePagamentoUseCase(ticketParquimetroDomainService);
    }

}
