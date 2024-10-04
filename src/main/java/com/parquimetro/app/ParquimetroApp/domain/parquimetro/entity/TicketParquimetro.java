package com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketParquimetro {
	
	private Long id;
	private Long idParquimetro;
    private String placaCarro;
    private LocalDateTime horaCadastro;
    private LocalDateTime horaSaida;
    
    private TicketParquimetro(final String placaCarro, final Long idParquimetro,final LocalDateTime horaCadastro,final LocalDateTime horaSaida) {
        this.placaCarro = placaCarro;
        this.idParquimetro = idParquimetro;
        this.horaCadastro = horaCadastro;
        this.horaSaida = horaSaida;
    }
    private TicketParquimetro(final Long id,final String placaCarro, final Long idParquimetro,final LocalDateTime horaCadastro,final LocalDateTime horaSaida) {
        this(placaCarro, idParquimetro, horaCadastro, horaSaida);
        this.id=id;
    }

    public static TicketParquimetro newTicket(final String placaCarro, final Long idParquimetro,final LocalDateTime horaCadastro) {
        return new TicketParquimetro(placaCarro, idParquimetro,horaCadastro,null);
    }

    public static TicketParquimetro with(final Long id,final String placaCarro, final Long idParquimetro, final LocalDateTime horaCadastro,final LocalDateTime horaSaida) {
        return new TicketParquimetro(id,placaCarro, idParquimetro,horaCadastro,horaSaida);
    }
}
