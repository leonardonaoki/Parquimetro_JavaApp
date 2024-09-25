package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SessaoEstacionamento")
@Data
public class SessaoEstacionamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Será um índice
    private String placaDoCarro;
    private Long idParquimetro;

    // Informações sobre a sessão
    private Long tempoDeUso;
    private BigDecimal custoTotal;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod metodoDePagamento;

    public enum Status {
        EM_ATRASO,
        PAGO
    }

    public enum PaymentMethod {
        DINHEIRO,
        MOEDA,
        CARTAO,
        APLICATIVO
    }
}
