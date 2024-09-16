package com.parquimetro.app.ParquimetroApp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="Multa")
@Data
public class MultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parquimetro_id",updatable = false)
    @JoinColumn(name = "parquimetro_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_Multa"))
    private Long idSessaoEstacionamento;

    private LocalDateTime horarioGeracaoMulta;

    private BigDecimal valorAPagar;

    @Enumerated(EnumType.STRING)
    private Status statusPagamento;

    public enum Status {
        NAO_PAGO,
        PAGO
    }
}