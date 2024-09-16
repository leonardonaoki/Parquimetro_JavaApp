package com.parquimetro.app.ParquimetroApp.service;

import com.parquimetro.app.ParquimetroApp.entities.ParquimetroEntity;
import com.parquimetro.app.ParquimetroApp.repository.IParquimetroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParquimetroService {

    private IParquimetroRepository parquimetroRepository;

    public List<ParquimetroEntity> listarParquimetros(){
        return parquimetroRepository.findAll();
    };
}
