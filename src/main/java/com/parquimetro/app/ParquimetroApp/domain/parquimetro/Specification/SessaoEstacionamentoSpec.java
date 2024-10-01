package com.parquimetro.app.ParquimetroApp.domain.parquimetro.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity.StatusSessao;

public class SessaoEstacionamentoSpec {

	public static Specification<SessaoEstacionamentoEntity> buscaPorPlacaEmAberto(String placaCarro){
		return (root,query,cb) -> cb.and(cb.equal(root.get("placaCarro"), placaCarro), cb.notEqual(root.get("status"), StatusSessao.PAGO));
	}
	public static Specification<SessaoEstacionamentoEntity> buscaPorPlacaEIdParquimetroEmAberto(String placaCarro, Long idParquimetro){
		return (root,query,cb) -> cb.and(cb.equal(root.get("placaCarro"), placaCarro),cb.equal(root.get("idParquimetro"), idParquimetro), cb.notEqual(root.get("status"), StatusSessao.PAGO));
	}
}
