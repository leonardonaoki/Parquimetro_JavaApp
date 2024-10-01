package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateSaidaUseCase {

	@NonNull
    private final TicketParquimetroDomainService ticketParquimetroDomainService;
	
	
	public void execute(Input input) {
        ticketParquimetroDomainService.registraSaidaParquimetro(
        		input.idParquimetro,input.placaCarro );
    }

    public record Input(String placaCarro, Long idParquimetro) {
    }
}
