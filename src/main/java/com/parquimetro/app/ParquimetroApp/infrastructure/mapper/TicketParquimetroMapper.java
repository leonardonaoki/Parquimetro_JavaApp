package com.parquimetro.app.ParquimetroApp.infrastructure.mapper;

import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.CreateEntradaUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.UpdateSaidaUseCase;

public class TicketParquimetroMapper {

	 public CreateEntradaUseCase.Input from(String placaCarro, Long idParquimetro) {
	        return new CreateEntradaUseCase.Input(placaCarro, idParquimetro);
	    }
	 

	 public UpdateSaidaUseCase.Input from(Long idParquimetro, String placaCarro ) {
	        return new UpdateSaidaUseCase.Input(placaCarro, idParquimetro);
	    }
}
