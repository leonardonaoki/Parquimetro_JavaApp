package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CreateEntradaUseCase {

	@NonNull
    private final TicketParquimetroDomainService ticketParquimetroDomainService;
	
	
	public void execute(Input input) {
        ticketParquimetroDomainService.registraEntradaParquimetro(
        		TicketParquimetro.newTicket(input.placaCarro, input.idParquimetro, LocalDateTime.now()) );
 
    }

    public record Input(String placaCarro, Long idParquimetro, LocalDateTime horaCadastro) {
    }
}
