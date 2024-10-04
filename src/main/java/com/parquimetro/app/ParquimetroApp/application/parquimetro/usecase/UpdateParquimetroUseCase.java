package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.application.dto.CreateUpdateParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.application.dto.ParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.application.dto.UpdateParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.ParquimetroJPAEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UpdateParquimetroUseCase {

    @NonNull
    private final ParquimetroDomainService ParquimetroDomainService;

    public Output execute(Input input) {
        final var parquimetro = ParquimetroDomainService.updateParquimetro(
                Parquimetro.with(
                    input.id(), 
                    input.endereco(), 
                    input.precoPorHora(),
                    ParquimetroDTO.StatusEnum.valueOf(input.status.toString())
                )
            );
        return Output.from(parquimetro);
    }

    public record Input(Long id, String endereco, Double precoPorHora, UpdateParquimetroDTO.StatusEnum status) {

    }

    public record Output(Long id, String endereco, Double precoPorHora, LocalDateTime dataCadastro, ParquimetroDTO.StatusEnum status) {

        public static Output from(Parquimetro parquimetro) {
            return new Output(
                    parquimetro.getId(),
                    parquimetro.getEndereco(),
                    parquimetro.getPrecoPorHora(),
                    parquimetro.getDataCadastro(),
                    parquimetro.getStatus()
                    );
        }
    }
}
