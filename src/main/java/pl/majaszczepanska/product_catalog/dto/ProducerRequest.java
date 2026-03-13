package pl.majaszczepanska.product_catalog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProducerRequest {
    @NotBlank(message = "Producer name is required")
    private String name;
}