package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity;

import java.time.LocalDateTime;

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
	
    private Long idParquimetro;
    private String placaCarro;
    private LocalDateTime horaCadastro;
    private LocalDateTime horaSaida;
}
