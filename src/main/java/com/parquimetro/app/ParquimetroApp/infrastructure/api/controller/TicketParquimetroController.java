package com.parquimetro.app.ParquimetroApp.infrastructure.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.CreateEntradaUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.UpdateEntradaUseCase;
import com.parquimetro.app.parquimetroapp.api.controller.TicketParquimetroApi;
import com.parquimetro.app.parquimetroapp.application.dto.ParquimetroPaginadoDTO;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TicketParquimetroController implements TicketParquimetroApi {

	@NonNull
    private final CreateEntradaUseCase createEntradaUseCase;
	@NonNull
    private final UpdateEntradaUseCase updateEntradaUseCase;
	
	@Override
    public  ResponseEntity<Void> registraEntradaParquimetro(final Long idParquimetro,final String placaCarro) {
		createEntradaUseCase.execute(placaCarro);
    }
	
	@Override
    public  ResponseEntity<Void> registraSaidaParquimetro(final Long idParquimetro ,final String placaCarro) {
		updateEntradaUseCase.execute(placaCarro);
    }
	/*
	@Override
    public  ResponseEntity<Void> buscarRegistroCarros(final String placaCarro) {
    }
	
	@Override
    public  ResponseEntity<Void> recebePagamentos(final String placaCarro) {
    }*/

}
