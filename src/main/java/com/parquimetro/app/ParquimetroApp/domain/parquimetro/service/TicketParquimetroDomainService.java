package com.parquimetro.app.ParquimetroApp.domain.parquimetro.service;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.TicketParquimetroGateway;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketParquimetroDomainService {

	 @NonNull
	 private final TicketParquimetroGateway ticketParquimetroGateway;
	 
	 
	 public void registraEntradaParquimetro(TicketParquimetro ticket) {
		 ticketParquimetroGateway.createEntradaParquimetro(ticket);        
	       
	 }
	 
	 public void registraSaidaParquimetro(final Long idParquimetro,final String placaCarro) {
		 ticketParquimetroGateway.updateSaidaParquimetro(idParquimetro,placaCarro);        
	       
	 }
}
