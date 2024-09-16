package com.parquimetro.app.ParquimetroApp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="Parquimetro")
@Data
public class ParquimetroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String endereco;

    @DecimalMin(value = "0.1")
    @Positive
    private BigDecimal precoPorHora;

    @Positive
    private Integer quantidadeMaximaDeHoras;
}