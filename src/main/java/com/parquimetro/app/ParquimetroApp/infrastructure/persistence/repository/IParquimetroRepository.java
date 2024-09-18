package com.parquimetro.app.parquimetroapp.infrastructure.persistence.repository;

import com.parquimetro.app.parquimetroapp.infrastructure.persistence.entity.ParquimetroJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParquimetroRepository extends JpaRepository<ParquimetroJPAEntity, Long> {
}
