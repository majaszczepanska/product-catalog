package pl.majaszczepanska.product_catalog.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import pl.majaszczepanska.product_catalog.dto.ProducerRequest;
import pl.majaszczepanska.product_catalog.dto.ProducerResponse;
import pl.majaszczepanska.product_catalog.model.Producer;
import pl.majaszczepanska.product_catalog.repository.ProducerRepository;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerRepository producerRepository;
    
    //GET - get all producers
    public List<ProducerResponse> getAllProducers() {
        return producerRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    //POST - create new producer
    public ProducerResponse createProducer(ProducerRequest request) {
        Producer producer = new Producer();
        producer.setName(request.getName());
        Producer savedProducer = producerRepository.save(producer);
        return mapToResponse(savedProducer);
    }

    //PUT - update producer by id
    public ProducerResponse updateProducer(Long id, ProducerRequest request) {
        Producer existingProducer = producerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found"));
        
        existingProducer.setName(request.getName());
        Producer updatedProducer = producerRepository.save(existingProducer);
        return mapToResponse(updatedProducer);
    }

    //DELETE - delete producer by id
    public void deleteProducer(Long id) {
        Producer existingProducer = producerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found"));
        producerRepository.delete(existingProducer);    
    }

    //Method to map Producer entity to ProducerResponse DTO
    private ProducerResponse mapToResponse(Producer producer) {
        ProducerResponse response = new ProducerResponse();
        response.setId(producer.getId());
        response.setName(producer.getName());
        return response;
    }
}
