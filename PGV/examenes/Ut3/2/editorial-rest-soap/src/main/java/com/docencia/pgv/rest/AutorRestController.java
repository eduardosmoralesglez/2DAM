package com.docencia.pgv.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.docencia.pgv.interfaces.AutorService;
import com.docencia.pgv.modelo.Autor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/autores")
public class AutorRestController {

    private final AutorService autorService;

    public AutorRestController(AutorService autorService) {
        this.autorService = autorService;
    }

    @Operation(summary = "Listar autores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
    })
    @GetMapping("/")
    public List<Autor> listar() {
        return autorService.findAll();
    }

    @Operation(summary = "Buscar autor por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Autor not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        Autor tarea = autorService.findByIdOrThrow(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }

    @Operation(summary = "Crear autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "201", description = "Autor Crated"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping
    public Autor crear(@Valid @RequestBody Autor autor) {
        return autorService.create(autor);
    }

    @Operation(summary = "Eliminar autor por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Autor Not Found")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        autorService.delete(id);
    }
}
