package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISessaoEstacionamentoRepository extends JpaRepository<SessaoEstacionamentoEntity, Long> {
}
