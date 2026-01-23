package com.docencia.aed.controller;

import com.docencia.aed.entity.Publisher;
import com.docencia.aed.service.IPublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Publishers", description = "Endpoints de editoriales")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({"/api/v1", "/api/v2"})
public class PublisherController {

    private final IPublisherService publisherService;

    public PublisherController(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Operation(summary = "Get all publishers")
    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers() {
        return publisherService.findAll();
    }

    @Operation(summary = "Create publisher")
    @PostMapping("/publishers")
    public ResponseEntity<Publisher> createPublisher(@Valid @RequestBody Publisher publisher) {
        Publisher created = publisherService.create(publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
