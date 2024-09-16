package com.parquimetro.app.ParquimetroApp.repository;

import com.parquimetro.app.ParquimetroApp.entities.MultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMultaRepository extends JpaRepository<MultaEntity, Long> {
}
