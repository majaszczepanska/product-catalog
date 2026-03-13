package pl.majaszczepanska.product_catalog.dto;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Data;

@Data
public class ProductRespone {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String producerName;
    private Map<String, Object> attributes;
}
