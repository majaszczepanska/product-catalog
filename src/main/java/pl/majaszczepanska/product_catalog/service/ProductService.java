package pl.majaszczepanska.product_catalog.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import pl.majaszczepanska.product_catalog.dto.ProductRequest;
import pl.majaszczepanska.product_catalog.dto.ProductResponse;
import pl.majaszczepanska.product_catalog.model.Producer;
import pl.majaszczepanska.product_catalog.model.Product;
import pl.majaszczepanska.product_catalog.repository.ProducerRepository;
import pl.majaszczepanska.product_catalog.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProducerRepository producerRepository;

    //GET - get all products
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    //POST - create new product
    public ProductResponse createProduct(ProductRequest request) {
        Producer producer = producerRepository.findById(request.getProducerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found"));
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setProducer(producer);
        product.setAttributes(request.getAttributes());

        Product savedProduct = productRepository.save(product);
        return mapToResponse(savedProduct);
    }

    //PUT - update product by id
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setAttributes(request.getAttributes());

        Product updatedProduct = productRepository.save(product);
        return mapToResponse(updatedProduct);
    }

    //DELETE - delete product by id
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    //GET - get products by name and/or producer name
    public List<ProductResponse> getProducts(String name, String producerName) {
        List<Product> products;
        if (name != null && producerName != null) {
            products = productRepository.findByNameContainingIgnoreCaseAndProducer_NameIgnoreCase(name, producerName);
        } else if (name != null) {
            products = productRepository.findByNameContainingIgnoreCase(name);
        } else if (producerName != null) {
            products = productRepository.findByProducer_NameIgnoreCase(producerName);
        } else {
            products = productRepository.findAll();
        }
        return products.stream()
                .map(this::mapToResponse)
                .toList();
    }

    //Method to map Product entity to ProductResponse DTO
    private ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setProducerName(product.getProducer().getName());
        response.setAttributes(product.getAttributes());
        return response;
    }
    
}
