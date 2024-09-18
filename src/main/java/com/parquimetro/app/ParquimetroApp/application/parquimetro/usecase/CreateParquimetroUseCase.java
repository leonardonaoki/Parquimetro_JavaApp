package com.parquimetro.app.parquimetroapp.application.parquimetro.usecase;

import com.parquimetro.app.parquimetroapp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.parquimetroapp.domain.parquimetro.service.ParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateParquimetroUseCase {

    @NonNull
    private final ParquimetroDomainService ParquimetroDomainService;

    public Output execute(Input input) {
        final var createdParquimetro = ParquimetroDomainService.createParquimetro(
            Parquimetro.newParquimetro(
                input.endereco(), 
                input.precoPorHora()
            ));
        return Output.from(createdParquimetro);
    }

    public record Input(String endereco, Double precoPorHora) {
    }

    public record Output(Long id, String endereco, Double precoPorHora) {

        public static Output from(Parquimetro Parquimetro) {
            return new Output(
                    Parquimetro.getId(), 
                    Parquimetro.getEndereco(), 
                    Parquimetro.getPrecoPorHora());
        }
    }
}
