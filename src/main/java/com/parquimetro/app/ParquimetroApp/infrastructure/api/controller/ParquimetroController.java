package com.parquimetro.app.ParquimetroApp.infrastructure.api.controller;

import com.parquimetro.app.ParquimetroApp.api.controller.ParquimetroApi;
import com.parquimetro.app.ParquimetroApp.application.dto.*;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.parquimetro.app.ParquimetroApp.infrastructure.mapper.ParquimetroMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ParquimetroController implements ParquimetroApi {

    @NonNull
    private final GetAllParquimetrosUseCase getAllParquimetrosUseCase;
    @NonNull
    private final GetParquimetroByIdUseCase getParquimetroByIdUseCase;
    @NonNull
    private final CreateParquimetroUseCase createParquimetroUseCase;
    @NonNull
    private final UpdateParquimetroUseCase updateParquimetroUseCase;
    @NonNull
    private final UpdateSaidaUseCase updateSaidaUseCase;
    @NonNull
    private final DeleteParquimetroUseCase deleteParquimetroUseCase;
    @NonNull
    private final ParquimetroMapper ParquimetroMapper;

    @Override
    public ResponseEntity<ParquimetroPaginadoDTO> listaParquimetros(final Integer page, final Integer size) {
        final var Parquimetros = getAllParquimetrosUseCase.execute(page, size);
        final var ParquimetrosResponse = ParquimetroMapper.toDTO(Parquimetros);
        return ResponseEntity.ok(ParquimetrosResponse);
    }

    @Override
    public ResponseEntity<ParquimetroDTO> listaParquimetroPeloId(final Long id) {
        final var Parquimetro = getParquimetroByIdUseCase.execute(id);
        final var ParquimetroDTO = ParquimetroMapper.toDTO(Parquimetro);
        return ResponseEntity.ok(ParquimetroDTO);
    }

    @Override
    public ResponseEntity<ParquimetroDTO> criaParquimetro(final CreateParquimetroDTO Parquimetro) {
        final var createdParquimetro = createParquimetroUseCase.execute(ParquimetroMapper.from(Parquimetro));
        return ResponseEntity.status(HttpStatus.CREATED).body(ParquimetroMapper.toDTO(createdParquimetro));
    }

    @Override
    public ResponseEntity<ParquimetroDTO> atualizaUmParquimetroPeloId(final Long id, final UpdateParquimetroDTO Parquimetro) {
        final var updatedParquimetro = updateParquimetroUseCase.execute(ParquimetroMapper.from(id, Parquimetro));
        return ResponseEntity.ok(ParquimetroMapper.toDTO(updatedParquimetro));
    }
    @Override
    public ResponseEntity<Void> deletaParquimetroPeloId(final Long id) {
        deleteParquimetroUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
