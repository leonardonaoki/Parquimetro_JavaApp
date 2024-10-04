package com.parquimetro.app.ParquimetroApp.infrastructure.mapper;

import com.parquimetro.app.ParquimetroApp.application.dto.*;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.CreateEntradaUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.GetAllParquimetrosUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.GetAllTicketParquimetrosUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.UpdateSaidaUseCase;
import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;

import java.time.LocalDateTime;

public class TicketParquimetroMapper {

	public TicketParquimetroPaginadoDTO toDTO(final Pagination<GetAllTicketParquimetrosUseCase.Output> pagination) {
		final var paginationDTO =
				new PaginationDTO()
						.page(pagination.page())
						.size(pagination.size())
						.total(pagination.total())
						.totalPages(pagination.totalPages());

		return new TicketParquimetroPaginadoDTO()
				.data(
						pagination.items()
								.stream()
								.map(this::toDTO).toList()
				)
				.pagination(paginationDTO);
	}

	public TicketParquimetroDTO toDTO(final GetAllTicketParquimetrosUseCase.Output output) {
		return new TicketParquimetroDTO()
				.idParquimetro(output.idParquimetro())
				.placaCarro(output.placaCarro())
				.id(output.id())
				.horaCadastro(output.horaCadastro())
				.horaSaida(output.horaSaida());

	}

	 public CreateEntradaUseCase.Input from(final CreateTicketParquimetroDTO dto) {
	        return new CreateEntradaUseCase.Input(dto.getPlacaCarro(), dto.getIdParquimetro(), LocalDateTime.now());
	    }
	 

	 public UpdateSaidaUseCase.Input from(final UpdateTicketParquimetroDTO dto) {
	        return new UpdateSaidaUseCase.Input(dto.getPlacaCarro(), dto.getIdParquimetro());
	    }
}
