package com.docencia.aed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.entity.Publisher;
import com.docencia.aed.service.impl.PublisherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/publishers")
@Tag(name = "Publishers", description = "Operaciones sobre publishers")
public class PublisherController {

    private PublisherService publisherService;

    @Autowired
    public void setPublisherService(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Operation(summary = "Get all Publishers")
    @GetMapping("/")
    public List<Publisher> getAllPublishers() {
        return publisherService.findAll();
    }

    @Operation(summary = "Insert Publisher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publisher created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/")
    public Publisher createPublisher(@Valid @RequestBody Publisher Publisher) {
        return publisherService.create(Publisher);
    }

}
