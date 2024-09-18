package com.parquimetro.app.parquimetroapp.application.parquimetro.usecase;

import com.parquimetro.app.parquimetroapp.domain.parquimetro.service.ParquimetroDomainService;

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
