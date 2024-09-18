package com.parquimetro.app.parquimetroapp.domain.parquimetro.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parquimetro {

    private Long id;
    private String endereco;
    private Double precoPorHora;

    private Parquimetro(final String endereco, final Double precoPorHora) {
        this.endereco = endereco;
        this.precoPorHora = precoPorHora;
    }

    private Parquimetro(final Long id, final String endereco, final Double precoPorHora) {
        this(endereco, precoPorHora);
        this.id = id;
    }

    public static Parquimetro with(final String endereco, final Double precoPorHora) {
        return new Parquimetro(endereco, precoPorHora);
    }

    public static Parquimetro with(final Long id, final String endereco, final Double precoPorHora) {
        return new Parquimetro(id, endereco, precoPorHora);
    }

    public static Parquimetro newParquimetro(final String endereco, final Double precoPorHora) {
        return new Parquimetro(endereco, precoPorHora);
    }
}
