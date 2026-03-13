package pl.majaszczepanska.product_catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    //POST - create new product
    public ProductResponse createProduct(ProductRequest request) {
        Producer producer = producerRepository.findById(request.getProducerId())
                .orElseThrow(() -> new RuntimeException("Producer not found"));
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
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
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
    
}
