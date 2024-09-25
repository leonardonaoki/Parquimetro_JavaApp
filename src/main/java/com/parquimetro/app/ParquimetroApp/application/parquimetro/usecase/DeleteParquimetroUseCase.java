package com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.service.ParquimetroDomainService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteParquimetroUseCase {

    @NonNull
    private final ParquimetroDomainService ParquimetroDomainService;

    public void execute(final Long ParquimetroId) {
        this.ParquimetroDomainService.deleteParquimetroById(ParquimetroId);
    }    
}
