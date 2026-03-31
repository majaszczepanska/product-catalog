package pl.majaszczepanska.product_catalog.analytics.dto;

import java.util.List;

public class ProducerAnalyticsDTO {

    private List<ProducerSummary> highValueProducers;
    private List<ProducerSummary> inactiveProducers;
    private List<ProducerSegment> producerSegments;

    public List<ProducerSummary> getHighValueProducers() {
        return highValueProducers;
    }

    public void setHighValueProducers(List<ProducerSummary> highValueProducers) {
        this.highValueProducers = highValueProducers;
    }

    public List<ProducerSummary> getInactiveProducers() {
        return inactiveProducers;
    }

    public void setInactiveProducers(List<ProducerSummary> inactiveProducers) {
        this.inactiveProducers = inactiveProducers;
    }

    public List<ProducerSegment> getProducerSegments() {
        return producerSegments;
    }

    public void setProducerSegments(List<ProducerSegment> producerSegments) {
        this.producerSegments = producerSegments;
    }
}
