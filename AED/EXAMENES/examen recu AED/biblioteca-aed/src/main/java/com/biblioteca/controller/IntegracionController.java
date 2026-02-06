package com.biblioteca.controller;

import com.biblioteca.dto.ResumenSocioResponse;
import com.biblioteca.service.IntegracionBibliotecaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/integracion")
public class IntegracionController {

    private final IntegracionBibliotecaService integracionService;

    public IntegracionController(IntegracionBibliotecaService integracionService) {
        this.integracionService = integracionService;
    }

    @GetMapping("/socios/{socioId}/resumen")
    public ResumenSocioResponse resumen(@PathVariable Long socioId) {
        return integracionService.getResumenSocio(socioId);
    }
}
