package com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity;

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
    
    private TicketParquimetro(final String placaCarro, final Long idParquimetro) {
        this.placaCarro = placaCarro;
        this.idParquimetro = idParquimetro;
        this.horaCadastro = LocalDateTime.now() ;
    }
    public static TicketParquimetro newTicket(final String placaCarro, final Long idParquimetro) {
        return new TicketParquimetro(placaCarro, idParquimetro);
    }
}
