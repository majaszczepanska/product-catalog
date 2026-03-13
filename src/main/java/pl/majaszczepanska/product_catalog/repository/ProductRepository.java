package pl.majaszczepanska.product_catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.majaszczepanska.product_catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProducer_NameIgnoreCase(String producerName);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByNameContainingIgnoreCaseAndProducer_NameIgnoreCase(String name, String producerName);
}                 
