package com.parquimetro.app.ParquimetroApp.service;

import com.parquimetro.app.ParquimetroApp.entities.SessaoEstacionamentoEntity;
import com.parquimetro.app.ParquimetroApp.repository.ISessaoEstacionamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessaoEstacionamentoService {

    private ISessaoEstacionamentoRepository sessaoEstacionamentoRepository;

    public List<SessaoEstacionamentoEntity> listaSessoesEstacionamento(){
        return sessaoEstacionamentoRepository.findAll();
    }
}
