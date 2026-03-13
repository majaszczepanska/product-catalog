package pl.majaszczepanska.product_catalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pl.majaszczepanska.product_catalog.dto.ProducerRequest;
import pl.majaszczepanska.product_catalog.dto.ProducerResponse;
import pl.majaszczepanska.product_catalog.service.ProducerService;

@RestController
@RequestMapping("/producers")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping
    public List<ProducerResponse> getAll() {
        return producerService.getAllProducers();
    }

    @PostMapping
    public ProducerResponse create(@Valid @RequestBody ProducerRequest request) {
        return producerService.createProducer(request);
    }

    @PutMapping("/{id}")
    public ProducerResponse update(@PathVariable Long id, @Valid @RequestBody ProducerRequest request) {
        return producerService.updateProducer(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        producerService.deleteProducer(id);
    }
}
