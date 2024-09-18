package com.parquimetro.app.parquimetroapp.domain.parquimetro.exception;

import com.parquimetro.app.parquimetroapp.domain.DomainException;

public class ParquimetroNotFoundException extends DomainException {

    private static final int HTTP_STATUS_NOT_FOUND = 404;
    private static final String Parquimetro_ID_NAO_ENCONTRADO = "Parquimetro com o id %d não encontrado";
    private static final String Parquimetro_NAO_ENCONTRADO = "Parquimetro não encontrado";

    public ParquimetroNotFoundException(final Long ParquimetroId) {
        super(Parquimetro_NAO_ENCONTRADO, String.format(Parquimetro_ID_NAO_ENCONTRADO, ParquimetroId), HTTP_STATUS_NOT_FOUND);
    }

}
