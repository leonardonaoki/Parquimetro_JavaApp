package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.application.dto.CreateUpdateParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.application.dto.ParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.ParquimetroJPAEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CreateParquimetroUseCase {

    @NonNull
    private final ParquimetroDomainService ParquimetroDomainService;

    public Output execute(Input input) {
        final var createdParquimetro = ParquimetroDomainService.createParquimetro(
            Parquimetro.newParquimetro(
                input.endereco(), 
                input.precoPorHora(),
                LocalDateTime.now(),
                ParquimetroDTO.StatusEnum.LIVRE
            ));
        return Output.from(createdParquimetro);
    }

    public record Input(String endereco, Double precoPorHora) {
    }

    public record Output(Long id, String endereco, Double precoPorHora, LocalDateTime horaCadastro,
                         ParquimetroDTO.StatusEnum Status) {

        public static Output from(Parquimetro Parquimetro) {
            return new Output(
                    Parquimetro.getId(), 
                    Parquimetro.getEndereco(), 
                    Parquimetro.getPrecoPorHora(),
                    Parquimetro.getDataCadastro(),
                    Parquimetro.getStatus());
        }
    }
}
