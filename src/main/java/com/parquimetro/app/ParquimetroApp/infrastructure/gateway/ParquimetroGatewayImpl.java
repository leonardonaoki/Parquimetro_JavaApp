package com.parquimetro.app.ParquimetroApp.infrastructure.gateway;

import java.util.Optional;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.ParquimetroJPAEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.ParquimetroGateway;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository.IParquimetroRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParquimetroGatewayImpl implements ParquimetroGateway {

    private final IParquimetroRepository parquimetroJPARepository;

    @Override
    public Parquimetro createParquimetro(final Parquimetro parquimetro) {
        return parquimetroJPARepository.save(ParquimetroJPAEntity.of(parquimetro)).toParquimetro();
    }

    @Override
    public Optional<Parquimetro> getParquimetroById(final Long parquimetroId) {
        return parquimetroJPARepository.findById(parquimetroId).map(ParquimetroJPAEntity::toParquimetro);
    }

    @Override
    public Pagination<Parquimetro> findAll(final int page, final int size) {
        final var pageable = Pageable.ofSize(size).withPage(page);
        Page<Parquimetro> listaParquimetro = parquimetroJPARepository.findAll(pageable).map(ParquimetroJPAEntity::toParquimetro);
        return Pagination.from(listaParquimetro.getNumber(), listaParquimetro.getSize(), (int) listaParquimetro.getTotalElements(),
                listaParquimetro.getTotalPages(), listaParquimetro.getContent());
    }

    @Override
    public Parquimetro updateParquimetro(final Parquimetro novoParquimetro) {
        return parquimetroJPARepository.save(ParquimetroJPAEntity.of(novoParquimetro)).toParquimetro();
    }
   
    @Override
    public void deleteParquimetro(final Long parquimetroId) {
        parquimetroJPARepository.deleteById(parquimetroId);
    }    

}
