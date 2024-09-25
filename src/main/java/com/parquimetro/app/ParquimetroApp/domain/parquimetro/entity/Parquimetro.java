package com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity;

import java.time.LocalDate;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.ParquimetroJPAEntity.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parquimetro {

    private Long id;
    private String endereco;
    private Double precoPorHora;
    private LocalDate dataCadastro;
    private Status status;

    private Parquimetro(final String endereco, final Double precoPorHora,final LocalDate dataCadastro) {
        this.endereco = endereco;
        this.precoPorHora = precoPorHora;
        this.dataCadastro = dataCadastro ;
    }

    private Parquimetro(final Long id, final String endereco, final Double precoPorHora,final LocalDate dataCadastro) {
        this(endereco, precoPorHora,dataCadastro);
        this.id = id;
    }

    public static Parquimetro with(final String endereco, final Double precoPorHora) {
        return new Parquimetro(endereco, precoPorHora,LocalDate.now());
    }

    public static Parquimetro with(final Long id, final String endereco, final Double precoPorHora) {
        return new Parquimetro(id, endereco, precoPorHora,null);
    }

    public static Parquimetro newParquimetro(final String endereco, final Double precoPorHora) {
        return new Parquimetro(endereco, precoPorHora,LocalDate.now());
    }
}
