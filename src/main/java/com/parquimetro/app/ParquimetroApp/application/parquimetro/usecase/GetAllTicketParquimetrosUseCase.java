package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.TicketParquimetroDomainService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetAllTicketParquimetrosUseCase {

    @NonNull
    private final TicketParquimetroDomainService TicketParquimetroDomainService;

    public Pagination<Output> execute(final int page, final int size) {
        return TicketParquimetroDomainService.listAllTicketsParquimetroUseCase(page, size).map(Output::from);
    }

    public record Output(Long id, Long idParquimetro, String placaCarro, LocalDateTime horaCadastro, LocalDateTime horaSaida) {

        public static Output from(final TicketParquimetro ticketParquimetro) {
            return new Output(
                    ticketParquimetro.getId(),
                    ticketParquimetro.getIdParquimetro(),
                    ticketParquimetro.getPlacaCarro(),
                    ticketParquimetro.getHoraCadastro(),
                    ticketParquimetro.getHoraSaida()
                    );
        }
    }

}
