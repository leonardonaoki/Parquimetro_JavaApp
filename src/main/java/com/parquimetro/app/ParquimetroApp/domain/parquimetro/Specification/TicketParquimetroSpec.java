package com.parquimetro.app.ParquimetroApp.domain.parquimetro.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.TicketParquimetroEntity;

public class TicketParquimetroSpec {

	public static Specification<TicketParquimetroEntity> buscaPorPlacaEIdParquimetro(String placaCarro, Long idParquimetro){
		return (root,query,cb) -> cb.and(cb.equal(root.get("placaCarro"), placaCarro), cb.equal(root.get("idParquimetro"), idParquimetro), cb.isNotNull(root.get("horaSaida")));
	}
	
	public static Specification<TicketParquimetroEntity> buscaRegistroPlacaEIdParquimetro(String placaCarro, Long idParquimetro){
		return (root,query,cb) -> cb.and(cb.equal(root.get("placaCarro"), placaCarro), cb.equal(root.get("idParquimetro"), idParquimetro));
	}
	
	public static Specification<TicketParquimetroEntity> buscaRegistroEmAberto(String placaCarro, Long idParquimetro){
		return (root,query,cb) -> cb.and(cb.equal(root.get("placaCarro"), placaCarro),cb.isNotNull(root.get("horaSaida")));
	}
}
