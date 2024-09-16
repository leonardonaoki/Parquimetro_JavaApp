package com.parquimetro.app.ParquimetroApp.entities;

import com.parquimetro.app.ParquimetroApp.entities.Key.VagaEstacionamentoKeyEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Table(name="VagaEstacionamento")
@Data
@IdClass(VagaEstacionamentoKeyEntity.class)
public class VagaEstacionamentoEntity {

    @Id
    @Positive
    private Long idParquimetro;

    @Id
    @PositiveOrZero
    private Integer numeroDaVaga;
    private Boolean statusVagaOcupada;

    @ManyToOne
    private ParquimetroEntity parquimetroEntity;
}