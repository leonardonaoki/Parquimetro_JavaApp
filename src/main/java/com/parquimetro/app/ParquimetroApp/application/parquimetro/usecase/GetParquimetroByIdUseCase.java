package com.parquimetro.app.parquimetroapp.application.parquimetro.usecase;

import com.parquimetro.app.parquimetroapp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.parquimetroapp.domain.parquimetro.service.ParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetParquimetroByIdUseCase {

    @NonNull
    private final ParquimetroDomainService ParquimetroDomainService;

    public Output execute(final Long ParquimetroId) {
        final var Parquimetro = ParquimetroDomainService.getParquimetroById(ParquimetroId);
        return Output.from(Parquimetro);
    }

    public record Output(Long id, String endereco, double precoPorHora) {

        public static Output from(final Parquimetro Parquimetro) {
            return new Output(
                    Parquimetro.getId(), 
                    Parquimetro.getEndereco(), 
                    Parquimetro.getPrecoPorHora()
                    );
        }
    }

}
