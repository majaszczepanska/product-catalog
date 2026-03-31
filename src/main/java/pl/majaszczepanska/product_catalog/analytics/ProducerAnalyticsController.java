package pl.majaszczepanska.product_catalog.analytics;

import pl.majaszczepanska.product_catalog.analytics.dto.ProducerAnalyticsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/analytics/producers")
public class ProducerAnalyticsController {

    private final ProducerAnalyticsService producerAnalyticsService;

    public ProducerAnalyticsController(ProducerAnalyticsService producerAnalyticsService) {
        this.producerAnalyticsService = producerAnalyticsService;
    }

    @GetMapping
    public ResponseEntity<ProducerAnalyticsDTO> getProducerAnalytics() {
        return ResponseEntity.ok(producerAnalyticsService.generateProducerAnalytics());
    }
}
