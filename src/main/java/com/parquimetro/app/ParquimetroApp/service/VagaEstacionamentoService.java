package com.parquimetro.app.ParquimetroApp.service;

import com.parquimetro.app.ParquimetroApp.entities.VagaEstacionamentoEntity;
import com.parquimetro.app.ParquimetroApp.repository.IVagaEstacionamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VagaEstacionamentoService {

    private IVagaEstacionamentoRepository vagaEstacionamentoRepository;

    public List<VagaEstacionamentoEntity> listarVagasEstacionamento(){
        return vagaEstacionamentoRepository.findAll();
    }

    public List<VagaEstacionamentoEntity> listaVagaEstacionamentoPorParquimetro(long idParquimetro){
        return vagaEstacionamentoRepository.findByIdParquimetro(idParquimetro);
    }
}
