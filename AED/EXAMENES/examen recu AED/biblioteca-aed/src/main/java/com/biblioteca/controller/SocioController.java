package com.biblioteca.controller;

import com.biblioteca.dto.SocioCreateRequest;
import com.biblioteca.model.Socio;
import com.biblioteca.service.SocioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @PostMapping
    public Socio crear(@RequestBody SocioCreateRequest req) {
        return socioService.crearSocio(req.nombre, req.email, req.fechaAlta);
    }

    @GetMapping
    public List<Socio> listar() {
        return socioService.listarSocios();
    }

    @GetMapping("/{id}")
    public Socio obtener(@PathVariable Long id) {
        return socioService.obtenerSocioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        socioService.eliminarSocio(id);
    }
}
