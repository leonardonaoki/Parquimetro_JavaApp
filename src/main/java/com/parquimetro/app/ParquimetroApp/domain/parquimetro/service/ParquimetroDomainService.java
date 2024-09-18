package com.parquimetro.app.parquimetroapp.domain.parquimetro.service;

import com.parquimetro.app.parquimetroapp.domain.pagination.Pagination;
import com.parquimetro.app.parquimetroapp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.parquimetroapp.domain.parquimetro.exception.ParquimetroNotFoundException;
import com.parquimetro.app.parquimetroapp.domain.parquimetro.gateway.ParquimetroGateway;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParquimetroDomainService {

    @NonNull
    private final ParquimetroGateway ParquimetroGateway;
            
    public Parquimetro createParquimetro(final Parquimetro newParquimetro) {
        final var createdParquimetro = ParquimetroGateway.createParquimetro(newParquimetro);        
        return createdParquimetro;
    }

    public Parquimetro updateParquimetro(final Parquimetro ParquimetroToUpdate) {
        final var existingParquimetro = ParquimetroGateway.getParquimetroById(ParquimetroToUpdate.getId())
                .orElseThrow(() -> new ParquimetroNotFoundException(ParquimetroToUpdate.getId()));
        
        final var updatedParquimetro = ParquimetroGateway.updateParquimetro(ParquimetroToUpdate);        
        return updatedParquimetro;
    }

    public void deleteParquimetroById(final Long id) {
        final var Parquimetro = ParquimetroGateway.getParquimetroById(id)
                .orElseThrow(() -> new ParquimetroNotFoundException(id));
        
        ParquimetroGateway.deleteParquimetro(id);
    }

    public Parquimetro getParquimetroById(Long ParquimetroId) {
        return ParquimetroGateway.getParquimetroById(ParquimetroId)
                .orElseThrow(() -> new ParquimetroNotFoundException(ParquimetroId));
    }

    public Pagination<Parquimetro> listAllParquimetros(int page, int size) {
        return ParquimetroGateway.findAll(page, size);
    }    
}
