package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PagarDividaEmAbertoUseCase {

	@NonNull
    private final TicketParquimetroDomainService ticketParquimetroDomainService;
	
	
	public void execute(Input input) {
      ticketParquimetroDomainService.pagarDividaEmAbertoUseCase(input.placaCarro,input.MetodoPagamento );
    }

    public record Input(String placaCarro, String MetodoPagamento) {
    }
}
