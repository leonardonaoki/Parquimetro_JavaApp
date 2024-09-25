package com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;

public interface TicketParquimetroGateway {

	void createEntradaParquimetro(TicketParquimetro ticket);

	void updateSaidaParquimetro(Long idParquimetro, String placaCarro);

}
