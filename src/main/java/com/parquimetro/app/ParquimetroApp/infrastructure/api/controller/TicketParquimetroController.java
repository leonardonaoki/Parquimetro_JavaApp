package com.parquimetro.app.ParquimetroApp.infrastructure.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.CreateEntradaUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.UpdateSaidaUseCase;
import com.parquimetro.app.ParquimetroApp.infrastructure.mapper.TicketParquimetroMapper;
//import com.parquimetro.app.parquimetroapp.api.controller.TicketParquimetroApi;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TicketParquimetroController /*implements TicketParquimetroApi*/ {

	@NonNull
    private final CreateEntradaUseCase createEntradaUseCase;
	@NonNull
    private final UpdateSaidaUseCase updateEntradaUseCase;
	
	@NonNull
    private final TicketParquimetroMapper ticketParquimetroMapper;
	
	//@Override
    public  void registraEntradaParquimetro(final Long idParquimetro,final String placaCarro) {
		createEntradaUseCase.execute(ticketParquimetroMapper.from(placaCarro, idParquimetro));
    }
	
	//@Override
    public  void registraSaidaParquimetro(final Long idParquimetro ,final String placaCarro) {
		updateEntradaUseCase.execute(ticketParquimetroMapper.from(idParquimetro, placaCarro));
    }
	/*
	@Override
    public  ResponseEntity<Double> CalculaValorParquimetro(final String placaCarro) {
    }
    
   	@Override
    public  ResponseEntity<Void> buscaDividaCarro(final String placaCarro) {
    }
	
	@Override
    public  ResponseEntity<Void> recebePagamentos(final String placaCarro) {
    }*/

}
