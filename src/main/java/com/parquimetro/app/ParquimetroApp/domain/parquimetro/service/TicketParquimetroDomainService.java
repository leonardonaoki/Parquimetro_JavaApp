package com.parquimetro.app.ParquimetroApp.domain.parquimetro.service;

import java.math.BigDecimal;

import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.TicketParquimetroGateway;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketParquimetroDomainService {

	 @NonNull
	 private final TicketParquimetroGateway ticketParquimetroGateway;

	public Pagination<TicketParquimetro> listAllTicketsParquimetroUseCase(int page, int size) {
		return ticketParquimetroGateway.findAll(page, size);
	}

	public void registraEntradaParquimetro(TicketParquimetro ticket) {
		 ticketParquimetroGateway.createEntradaParquimetro(ticket);        
	       
	 }
	 
	 public void registraSaidaParquimetro(final Long idParquimetro,final String placaCarro) {
		 ticketParquimetroGateway.updateSaidaParquimetro(idParquimetro,placaCarro);        	       
	 }
	 
	 public void pagarDividaEmAbertoUseCase(final String placaCarro, final String metodoPagamento) {
		  ticketParquimetroGateway.pagarDividaEmAberto(placaCarro, metodoPagamento);
	 }
	 
	 public BigDecimal buscaDividaCarro(final String placaCarro) {
		 return ticketParquimetroGateway.buscaDividaCarro(placaCarro); 
	  }
		
	public void recebePagamentos(String placaCarro, BigDecimal valorPagamento, Long idParquimetro,
			String metodoPagamento) {
		ticketParquimetroGateway.recebePagamentoParquimetro(valorPagamento,placaCarro, metodoPagamento,idParquimetro);
		
	}
}
