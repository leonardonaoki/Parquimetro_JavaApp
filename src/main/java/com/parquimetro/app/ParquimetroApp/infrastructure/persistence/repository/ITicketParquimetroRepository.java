package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.Specification.TicketParquimetroSpec;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.TicketParquimetroEntity;

public interface ITicketParquimetroRepository extends JpaRepository<TicketParquimetroEntity, Long> , JpaSpecificationExecutor<TicketParquimetroEntity>{

}
