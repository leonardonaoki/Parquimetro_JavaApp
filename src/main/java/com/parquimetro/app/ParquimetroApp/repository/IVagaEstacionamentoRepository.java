package com.parquimetro.app.ParquimetroApp.repository;

import com.parquimetro.app.ParquimetroApp.entities.VagaEstacionamentoEntity;
import com.parquimetro.app.ParquimetroApp.entities.Key.VagaEstacionamentoKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVagaEstacionamentoRepository extends JpaRepository<VagaEstacionamentoEntity, VagaEstacionamentoKeyEntity> {
    List<VagaEstacionamentoEntity> findByIdParquimetro(long idParquimetor);
}
