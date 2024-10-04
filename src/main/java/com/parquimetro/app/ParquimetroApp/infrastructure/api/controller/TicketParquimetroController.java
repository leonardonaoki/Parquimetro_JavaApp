package com.parquimetro.app.ParquimetroApp.infrastructure.api.controller;

import com.parquimetro.app.ParquimetroApp.api.controller.TicketParquimetroApi;
import com.parquimetro.app.ParquimetroApp.application.dto.*;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.GetAllParquimetrosUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.GetAllTicketParquimetrosUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.CreateEntradaUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.UpdateSaidaUseCase;
import com.parquimetro.app.ParquimetroApp.infrastructure.mapper.TicketParquimetroMapper;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TicketParquimetroController implements TicketParquimetroApi {

    @NonNull
    private final GetAllTicketParquimetrosUseCase getAllTicketParquimetrosUseCase;

	@NonNull
    private final CreateEntradaUseCase createEntradaUseCase;
	@NonNull
    private final UpdateSaidaUseCase updateEntradaUseCase;
	
	@NonNull
    private final TicketParquimetroMapper ticketParquimetroMapper;

    @Override
    public ResponseEntity<TicketParquimetroPaginadoDTO> listaTicketsParquimetrosPaginado(final Integer page, final Integer size) {
        final var TicketsParquimetro = getAllTicketParquimetrosUseCase.execute(page, size);
        final var TicketParquimetrosResponse = ticketParquimetroMapper.toDTO(TicketsParquimetro);
        return ResponseEntity.ok(TicketParquimetrosResponse);
    }

	@Override
    public ResponseEntity<Void> registraEntradaParquimetro(final CreateTicketParquimetroDTO ticketParquimetroDTO) {
		createEntradaUseCase.execute(ticketParquimetroMapper.from(ticketParquimetroDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> registraSaidaParquimetro(final UpdateTicketParquimetroDTO ticketParquimetroDTO) {
		updateEntradaUseCase.execute(ticketParquimetroMapper.from(ticketParquimetroDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
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
