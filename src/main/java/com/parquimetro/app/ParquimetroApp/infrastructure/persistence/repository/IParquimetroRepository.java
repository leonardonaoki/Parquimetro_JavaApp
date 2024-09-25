package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.ParquimetroJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParquimetroRepository extends JpaRepository<ParquimetroJPAEntity, Long> {
}
