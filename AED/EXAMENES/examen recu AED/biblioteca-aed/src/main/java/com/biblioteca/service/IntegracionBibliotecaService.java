package com.biblioteca.service;

import com.biblioteca.dto.ResumenSocioResponse;

public interface IntegracionBibliotecaService {
    ResumenSocioResponse getResumenSocio(Long socioId);
}
