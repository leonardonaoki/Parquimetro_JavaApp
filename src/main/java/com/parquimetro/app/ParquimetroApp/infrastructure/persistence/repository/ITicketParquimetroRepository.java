package com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.TicketParquimetroEntity;

public interface ITicketParquimetroRepository extends JpaRepository<TicketParquimetroEntity, Long> {

}
