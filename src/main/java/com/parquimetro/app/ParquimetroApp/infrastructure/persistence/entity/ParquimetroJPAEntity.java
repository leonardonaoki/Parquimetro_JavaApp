package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity.Status;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Parquimetro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParquimetroJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String endereco;

    @DecimalMin(value = "0.1")
    @Positive
    private Double precoPorHora;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public enum Status {
        OCUPADO,
        LIVRE
    }

    public static ParquimetroJPAEntity of(Parquimetro parquimetro) {
        return new ParquimetroJPAEntity(parquimetro.getId(), parquimetro.getEndereco(), parquimetro.getPrecoPorHora(),parquimetro.getStatus());
    }

    public Parquimetro toParquimetro() {
        return Parquimetro.with(this.id, this.endereco, this.precoPorHora);
    }
}