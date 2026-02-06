package com.biblioteca.controller;

import com.biblioteca.dto.PrestarLibroRequest;
import com.biblioteca.model.Prestamo;
import com.biblioteca.service.PrestamoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoLibroController {

    private final PrestamoService prestamoLibroService;

    public PrestamoLibroController(PrestamoService prestamoLibroService) {
        this.prestamoLibroService = prestamoLibroService;
    }

    @PostMapping
    public Prestamo prestar(@RequestBody PrestarLibroRequest req) {
        return prestamoLibroService.crearPrestamo(req.socioId, req.fechaInicio);
    }

    @PostMapping("/{id}/devolver")
    public Prestamo devolver(@PathVariable Long id) {
        return prestamoLibroService.devolverPrestamo(id);
    }

    @GetMapping("/activos/socio/{socioId}")
    public List<Prestamo> activosPorSocio(@PathVariable Long socioId) {
        return prestamoLibroService.listarPrestamosActivosPorSocio(socioId);
    }
    
}
