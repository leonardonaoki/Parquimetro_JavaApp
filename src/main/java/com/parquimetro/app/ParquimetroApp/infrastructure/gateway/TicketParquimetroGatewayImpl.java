package com.parquimetro.app.ParquimetroApp.infrastructure.gateway;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import com.parquimetro.app.ParquimetroApp.application.dto.CreateUpdateParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.application.dto.ParquimetroDTO;
import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import org.apache.commons.lang3.ObjectUtils;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.Specification.SessaoEstacionamentoSpec;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.Specification.TicketParquimetroSpec;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.gateway.TicketParquimetroGateway;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.ParquimetroJPAEntity;

import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity.PaymentMethod;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.SessaoEstacionamentoEntity.StatusSessao;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.entity.TicketParquimetroEntity;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository.IParquimetroRepository;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository.ISessaoEstacionamentoRepository;
import com.parquimetro.app.ParquimetroApp.infrastructure.persistence.repository.ITicketParquimetroRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class TicketParquimetroGatewayImpl implements TicketParquimetroGateway {

    private final ITicketParquimetroRepository ticketParquimetroRepository;
    private final IParquimetroRepository parquimetroJPARepository;
    private final ISessaoEstacionamentoRepository sessaoEstacionamentoRepository;

	@Override
	public Pagination<TicketParquimetro> findAll(final int page, final int size) {
		final var pageable = Pageable.ofSize(size).withPage(page);
		Page<TicketParquimetro> listaTicketsParquimetro = ticketParquimetroRepository.findAll(pageable).map(TicketParquimetroEntity::toTicketParquimetro);
		return Pagination.fromTicketParquimetro( listaTicketsParquimetro.getNumber(),  listaTicketsParquimetro.getSize(), (int)  listaTicketsParquimetro.getTotalElements(),
				listaTicketsParquimetro.getTotalPages(),  listaTicketsParquimetro.getContent());
	}

	@Override
	@Transactional
	public void createEntradaParquimetro(TicketParquimetro ticket) {
		//verificar se a placa do carro já está cadastrada em algum outro registro
		ticketParquimetroRepository.save(TicketParquimetroEntity.of(ticket));
		ParquimetroJPAEntity parquimetro =parquimetroJPARepository.findById(ticket.getIdParquimetro()).get();
		parquimetro.setStatus(ParquimetroDTO.StatusEnum.OCUPADO);
	}

	@Override
	@Transactional
	public void updateSaidaParquimetro(Long idParquimetro, String placaCarro) {

		Optional<TicketParquimetroEntity> ticketOptional = ticketParquimetroRepository.findOne(TicketParquimetroSpec.buscaRegistroPlacaEIdParquimetro(placaCarro, idParquimetro));
		if(!ObjectUtils.isEmpty(ticketOptional)) {

			TicketParquimetroEntity ticket = ticketOptional.get();
			ticket.setHoraSaida(LocalDateTime.now());
			ticketParquimetroRepository.save(ticket);
			ParquimetroJPAEntity parquimetro =parquimetroJPARepository.findById(ticket.getIdParquimetro()).get();
			parquimetro.setStatus(ParquimetroDTO.StatusEnum.LIVRE);
			calculaValorPaquimetro(ticket, parquimetro);
		}else {
			//registro não encontrado
		}
		
	}
	
	private void calculaValorPaquimetro(TicketParquimetroEntity ticket,ParquimetroJPAEntity parquimetro) {
		SessaoEstacionamentoEntity sessao = new SessaoEstacionamentoEntity();
		sessao.setIdParquimetro(parquimetro.getId());
		sessao.setPlacaDoCarro(ticket.getPlacaCarro());
		sessao.setStatus(StatusSessao.PENDENTE_PAGAMENTO);
		//Confirmar diferença horas e minutos
		Long minutos = ticket.getHoraCadastro().until(ticket.getHoraSaida(), ChronoUnit.MINUTES);
		BigDecimal valorCalculado = BigDecimal.valueOf(minutos*parquimetro.getPrecoPorHora());
		sessao.setCustoTotal(valorCalculado);
		sessaoEstacionamentoRepository.save(sessao);
	}

	@Override
	public void recebePagamentoParquimetro(BigDecimal valorPagamento, String placaCarro,String MetodoPagamento,Long idParquimetro) {
		Optional<SessaoEstacionamentoEntity> sessaoOptional =  sessaoEstacionamentoRepository.findOne(SessaoEstacionamentoSpec.buscaPorPlacaEIdParquimetroEmAberto(placaCarro,idParquimetro));
		if(!ObjectUtils.isEmpty(sessaoOptional)) {
			SessaoEstacionamentoEntity sessao = sessaoOptional.get();
			if(sessao.getCustoTotal().equals(valorPagamento)) {
				sessao.setStatus(StatusSessao.PAGO);
				sessao.setMetodoDePagamento(PaymentMethod.valueOf(MetodoPagamento));
			}		
		}
	}

	@Override
	public BigDecimal buscaDividaCarro(String placaCarro) {
		List<SessaoEstacionamentoEntity> sessaoList =  sessaoEstacionamentoRepository.findAll(SessaoEstacionamentoSpec.buscaPorPlacaEmAberto(placaCarro));
		//Oq vai ser considerado em atraso? 
		BigDecimal dividaEmAberto = new BigDecimal(0) ;
		for(var sessao: sessaoList) {
			dividaEmAberto.add(sessao.getCustoTotal());
		}
		return dividaEmAberto;
	}
	
	@Override
	public void pagarDividaEmAberto(String placaCarro,String MetodoPagamento) {
		List<SessaoEstacionamentoEntity> sessaoList =  sessaoEstacionamentoRepository.findAll(SessaoEstacionamentoSpec.buscaPorPlacaEmAberto(placaCarro));
		for(var sessao: sessaoList) {
			sessao.setStatus(StatusSessao.PAGO);
			sessao.setMetodoDePagamento(PaymentMethod.valueOf(MetodoPagamento));
		}
	}

}
