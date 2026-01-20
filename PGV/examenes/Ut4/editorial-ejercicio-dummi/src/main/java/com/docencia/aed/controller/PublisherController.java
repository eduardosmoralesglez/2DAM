package com.docencia.aed.controller;

import com.docencia.aed.entity.Publisher;
import com.docencia.aed.service.IPublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Publisher API")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
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
        return ResponseEntity.of(Optional.of(publisherService.create(publisher)));
    }
}
