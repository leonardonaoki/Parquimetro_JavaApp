package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity;

import java.time.LocalDateTime;

import org.springframework.data.domain.Persistable;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Ticket")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketParquimetroEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idParquimetro;
    @Column(nullable = false, length = 7)
    private String placaCarro;
    @Column(nullable = false)
    private LocalDateTime horaCadastro;
    @Column(nullable = true)
    private LocalDateTime horaSaida;
    
    public static TicketParquimetroEntity of(TicketParquimetro ticket) {
        return new TicketParquimetroEntity(ticket.getId(), ticket.getIdParquimetro(), ticket.getPlacaCarro()
        		,ticket.getHoraSaida(),ticket.getHoraCadastro());
    }

}
