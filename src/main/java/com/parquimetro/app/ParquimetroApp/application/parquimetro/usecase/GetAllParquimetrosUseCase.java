package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.application.dto.ParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
public class GetAllParquimetrosUseCase {

    @NonNull
    private final ParquimetroDomainService ParquimetroDomainService;

    public Pagination<Output> execute(final int page, final int size) {
        return ParquimetroDomainService.listAllParquimetros(page, size).map(Output::from);
    }

    public record Output(Long id, String endereco, Double precoPorHora, LocalDateTime horaCadastro,
                         ParquimetroDTO.StatusEnum status) {

        public static Output from(final Parquimetro Parquimetro) {
            return new Output(
                    Parquimetro.getId(), 
                    Parquimetro.getEndereco(), 
                    Parquimetro.getPrecoPorHora(),
                    Parquimetro.getDataCadastro(),
                    Parquimetro.getStatus()
                    );
        }
    }

}
