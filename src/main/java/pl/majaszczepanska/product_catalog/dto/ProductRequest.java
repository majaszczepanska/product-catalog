package pl.majaszczepanska.product_catalog.dto;

import java.math.BigDecimal;
import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive number")
    private BigDecimal price;

    @NotNull(message = "Producer ID is required")
    private Long producerId;
    
    private Map<String, Object> attributes;
}
