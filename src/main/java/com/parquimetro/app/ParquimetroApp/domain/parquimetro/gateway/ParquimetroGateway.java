package com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway;

import java.util.Optional;

import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;

public interface ParquimetroGateway {

    Parquimetro createParquimetro(Parquimetro Parquimetro);

    Optional<Parquimetro> getParquimetroById(Long ParquimetroId);

    Pagination<Parquimetro> findAll(int page, int size);

    Parquimetro updateParquimetro(Parquimetro newParquimetro);

    void deleteParquimetro(Long id);
}
