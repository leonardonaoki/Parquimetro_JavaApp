package com.parquimetro.app.ParquimetroApp.domain.pagination;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.Parquimetro;
import com.parquimetro.app.ParquimetroApp.domain.parquimetro.entity.TicketParquimetro;

public record Pagination<T>(int page, int size, int total, int totalPages, List<T> items) {

    public <R> Pagination<R> map(final Function<T, R> mapper) {
        final var mappedItems = this.items.stream().map(mapper).collect(Collectors.toList());
        final var totalPages = (total + size - 1) / size;
        return new Pagination<>(page, size, total, totalPages, mappedItems);
    }
    public static Pagination<Parquimetro> from(int page, int size, int total, int totalPages, List<Parquimetro> items) {
        return new Pagination<>(page, size, total, totalPages, items);
    }
    public static Pagination<TicketParquimetro> fromTicketParquimetro(int page, int size, int total, int totalPages, List<TicketParquimetro> items) {
        return new Pagination<>(page, size, total, totalPages, items);
    }
}
