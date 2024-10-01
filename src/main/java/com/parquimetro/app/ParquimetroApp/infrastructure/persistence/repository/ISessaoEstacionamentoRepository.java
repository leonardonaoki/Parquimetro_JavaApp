package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity;

public interface ISessaoEstacionamentoRepository extends JpaRepository<SessaoEstacionamentoEntity, Long>, JpaSpecificationExecutor<SessaoEstacionamentoEntity> {
}
