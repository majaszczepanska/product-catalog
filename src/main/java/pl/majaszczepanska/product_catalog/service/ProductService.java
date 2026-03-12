package pl.majaszczepanska.product_catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.majaszczepanska.product_catalog.dto.ProductRequest;
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
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    

    //POST - create new product
    public Product createProduct(ProductRequest request) {
        Producer producer = producerRepository.findById(request.getProducerId())
                .orElseThrow(() -> new RuntimeException("Producer not found"));
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setProducer(producer);
        product.setAttributes(request.getAttributes());

        return productRepository.save(product);
    }

    //PUT - update product by id
    public Product updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setAttributes(request.getAttributes());

         
        if(request.getProducerId() != null) {
            Producer producer = producerRepository.findById(request.getProducerId())
                    .orElseThrow(() -> new RuntimeException("Producer not found"));
            product.setProducer(producer);
        }

        return productRepository.save(product);
    }

    //DELETE - delete product by id
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
}
