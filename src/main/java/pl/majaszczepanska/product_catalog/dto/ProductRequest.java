package pl.majaszczepanska.product_catalog.dto;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Long producerId;
    private Map<String, Object> attributes;
}
