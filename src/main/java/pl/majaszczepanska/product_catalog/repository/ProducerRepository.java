package pl.majaszczepanska.product_catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.majaszczepanska.product_catalog.model.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    
} 
