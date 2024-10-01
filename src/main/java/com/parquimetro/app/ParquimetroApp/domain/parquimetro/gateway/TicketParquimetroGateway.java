package com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway;

import java.math.BigDecimal;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;

public interface TicketParquimetroGateway {

	void createEntradaParquimetro(TicketParquimetro ticket);

	void updateSaidaParquimetro(Long idParquimetro, String placaCarro);
		
	BigDecimal buscaDividaCarro(String placaCarro);

	void recebePagamentoParquimetro(BigDecimal valorPagamento, String placaCarro, String MetodoPagamento,
			Long idParquimetro);

	void pagarDividaEmAberto(String placaCarro, String MetodoPagamento);
}
