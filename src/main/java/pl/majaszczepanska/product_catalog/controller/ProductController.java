package pl.majaszczepanska.product_catalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pl.majaszczepanska.product_catalog.dto.ProductRequest;
import pl.majaszczepanska.product_catalog.dto.ProductResponse;
import pl.majaszczepanska.product_catalog.service.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    /*
    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAllProducts();
    } */

    @GetMapping
    public List<ProductResponse> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String producerName) {
        
        return productService.getProducts(name, producerName);
    }
    
    @PostMapping
    public ProductResponse create(@Valid @RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
