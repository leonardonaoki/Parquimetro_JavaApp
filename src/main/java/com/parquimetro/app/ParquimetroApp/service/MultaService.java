package com.parquimetro.app.ParquimetroApp.service;

import com.parquimetro.app.ParquimetroApp.entities.MultaEntity;
import com.parquimetro.app.ParquimetroApp.repository.IMultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MultaService {

    private IMultaRepository multaRepository;

    public List<MultaEntity> listarMultas(){
        return multaRepository.findAll();
    }
}
