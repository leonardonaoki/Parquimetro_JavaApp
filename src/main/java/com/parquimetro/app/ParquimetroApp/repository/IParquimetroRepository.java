package com.parquimetro.app.ParquimetroApp.repository;

import com.parquimetro.app.ParquimetroApp.entities.ParquimetroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParquimetroRepository extends JpaRepository<ParquimetroEntity, Long> {
}
