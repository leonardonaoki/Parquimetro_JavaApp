package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import java.math.BigDecimal;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecebePagamentoUseCase {


	@NonNull
    private final TicketParquimetroDomainService ticketParquimetroDomainService;
	
	
	public void execute(Input input) {
        ticketParquimetroDomainService.recebePagamentos(
        		input.placaCarro,input.valorPagamento,input.idParquimetro,input.MetodoPagamento );
    }

    public record Input(BigDecimal valorPagamento, String placaCarro,String MetodoPagamento,Long idParquimetro) {
    }
}
