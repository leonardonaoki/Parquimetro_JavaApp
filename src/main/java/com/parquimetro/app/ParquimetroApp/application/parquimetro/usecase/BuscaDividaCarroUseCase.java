package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import java.math.BigDecimal;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscaDividaCarroUseCase {

	@NonNull
    private final TicketParquimetroDomainService ticketParquimetroDomainService;
	
	
	public BigDecimal execute(Input input) {
       return  ticketParquimetroDomainService.buscaDividaCarro(input.placaCarro);
    }

    public record Input(String placaCarro) {
    }
}
