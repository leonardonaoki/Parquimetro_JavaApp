package com.parquimetro.app.ParquimetroApp.entities.Key;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class VagaEstacionamentoKeyEntity implements Serializable {

    private Long idParquimetro;
    private Integer numeroDaVaga;

}
