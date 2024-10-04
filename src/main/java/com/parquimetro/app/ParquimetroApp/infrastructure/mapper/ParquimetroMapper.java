package com.parquimetro.app.ParquimetroApp.infrastructure.mapper;

import com.parquimetro.app.ParquimetroApp.application.dto.*;

import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.CreateParquimetroUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.GetAllParquimetrosUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.GetParquimetroByIdUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.UpdateParquimetroUseCase;
import com.parquimetro.app.ParquimetroApp.application.parquimetro.usecase.UpdateParquimetroUseCase.Output;
import com.parquimetro.app.ParquimetroApp.domain.pagination.Pagination;

public class ParquimetroMapper {

    public ParquimetroDTO toDTO(final GetParquimetroByIdUseCase.Output output) {
        return new ParquimetroDTO().id(output.id())
                    .endereco(output.endereco())
                    .precoPorHora(output.precoPorHora());
    }

    public ParquimetroDTO toDTO(final CreateParquimetroUseCase.Output output) {
        return new ParquimetroDTO().id(output.id())
                    .endereco(output.endereco())
                    .precoPorHora(output.precoPorHora())
                    .dataCadastro(output.horaCadastro())
                    .status(output.Status())
                ;
    }

    public ParquimetroPaginadoDTO toDTO(final Pagination<GetAllParquimetrosUseCase.Output> pagination) {
        final var paginationDTO = 
            new PaginationDTO()
                .page(pagination.page())
                .size(pagination.size())
                .total(pagination.total())
                .totalPages(pagination.totalPages());

        return new ParquimetroPaginadoDTO()
            .data(
                pagination.items()
                .stream()
                .map(this::toDTO).toList()
            )
            .pagination(paginationDTO);
    }

    public ParquimetroDTO toDTO(final Output output) {
        return new ParquimetroDTO()
                .id(output.id())
                .endereco(output.endereco())
                .precoPorHora(output.precoPorHora())
                .status(output.status())
                .dataCadastro(output.dataCadastro());
    }

    public ParquimetroDTO toDTO(final GetAllParquimetrosUseCase.Output output) {
        return new ParquimetroDTO()
                .id(output.id())
                .endereco(output.endereco())
                .precoPorHora(output.precoPorHora());
    }

    public CreateParquimetroUseCase.Input from(final CreateParquimetroDTO dto) {
        return new CreateParquimetroUseCase.Input(dto.getEndereco(), dto.getPrecoPorHora());
    }

    public UpdateParquimetroUseCase.Input from(final Long id, final UpdateParquimetroDTO dto) {
        return new UpdateParquimetroUseCase.Input(id, dto.getEndereco(), dto.getPrecoPorHora(),dto.getStatus());
    }

}
