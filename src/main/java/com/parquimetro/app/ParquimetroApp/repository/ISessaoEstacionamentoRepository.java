package com.parquimetro.app.ParquimetroApp.repository;

import com.parquimetro.app.ParquimetroApp.entities.SessaoEstacionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISessaoEstacionamentoRepository extends JpaRepository<SessaoEstacionamentoEntity, Long> {
}
