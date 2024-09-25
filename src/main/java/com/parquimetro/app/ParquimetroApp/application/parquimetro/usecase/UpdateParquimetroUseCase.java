package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateParquimetroUseCase {

    @NonNull
    private final ParquimetroDomainService ParquimetroDomainService;

    public Output execute(Input input) {
        final var parquimetro = ParquimetroDomainService.updateParquimetro(
                Parquimetro.with(
                    input.id(), 
                    input.endereco(), 
                    input.precoPorHora()
                )
            );
        return Output.from(parquimetro);
    }

    public record Input(Long id, String endereco, Double precoPorHora) {

    }

    public record Output(Long id, String endereco, Double precoPorHora) {

        public static Output from(Parquimetro parquimetro) {
            return new Output(
                    parquimetro.getId(),
                    parquimetro.getEndereco(),
                    parquimetro.getPrecoPorHora()
                    );
        }
    }
}
