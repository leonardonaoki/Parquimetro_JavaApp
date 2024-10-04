package com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway;

import java.math.BigDecimal;

import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.TicketParquimetroEntity;

public interface TicketParquimetroGateway {

	Pagination<TicketParquimetro> findAll(int page, int size);

	void createEntradaParquimetro(TicketParquimetro ticket);

	void updateSaidaParquimetro(Long idParquimetro, String placaCarro);
		
	BigDecimal buscaDividaCarro(String placaCarro);

	void recebePagamentoParquimetro(BigDecimal valorPagamento, String placaCarro, String MetodoPagamento,
			Long idParquimetro);

	void pagarDividaEmAberto(String placaCarro, String MetodoPagamento);
}
