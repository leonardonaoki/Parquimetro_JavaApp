package com.parquimetro.app.ParquimetroApp.controller;

import com.parquimetro.app.ParquimetroApp.entities.ParquimetroEntity;
import com.parquimetro.app.ParquimetroApp.service.MultaService;
import com.parquimetro.app.ParquimetroApp.service.ParquimetroService;
import com.parquimetro.app.ParquimetroApp.service.SessaoEstacionamentoService;
import com.parquimetro.app.ParquimetroApp.service.VagaEstacionamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/parquimetro")
@RequiredArgsConstructor
public class ParquimetroController {
    private ParquimetroService parquimetroService;
    private MultaService multaService;
    private SessaoEstacionamentoService sessaoEstacionamentoService;
    private VagaEstacionamentoService vagaEstacionamentoService;

    public List<ParquimetroEntity> listarParquimetros(){
        return parquimetroService.listarParquimetros();
    }
}
