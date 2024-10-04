package com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.parquimetro.app.ParquimetroApp.application.dto.CreateUpdateParquimetroDTO;


import com.parquimetro.app.ParquimetroApp.application.dto.ParquimetroDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parquimetro {

    private Long id;
    private String endereco;
    private Double precoPorHora;
    private LocalDateTime dataCadastro;
    private ParquimetroDTO.StatusEnum status;

    private Parquimetro(final String endereco, final Double precoPorHora,final LocalDateTime dataCadastro, final ParquimetroDTO.StatusEnum status) {
        this.endereco = endereco;
        this.precoPorHora = precoPorHora;
        this.dataCadastro = dataCadastro;
        this.status= status;
    }
    private Parquimetro(final Long id,final String endereco, final Double precoPorHora,final LocalDateTime dataCadastro, final ParquimetroDTO.StatusEnum status) {
        this(endereco, precoPorHora, dataCadastro, status);
        this.id = id;
    }

    public static Parquimetro with(final Long id,final String endereco, final Double precoPorHora,final ParquimetroDTO.StatusEnum status) {
        return new Parquimetro(id,endereco, precoPorHora,LocalDateTime.now(),status);
    }

    public static Parquimetro newParquimetro(final String endereco, final Double precoPorHora, final LocalDateTime dataCadastro , final ParquimetroDTO.StatusEnum status) {
        return new Parquimetro(endereco, precoPorHora,dataCadastro,status.LIVRE);
    }
}
