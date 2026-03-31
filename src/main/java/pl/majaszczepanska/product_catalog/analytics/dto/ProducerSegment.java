package pl.majaszczepanska.product_catalog.analytics.dto;

import java.util.List;

public class ProducerSegment {

    private String segmentName;
    private List<ProducerSummary> producers;
    private int producerCount;

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public List<ProducerSummary> getProducers() {
        return producers;
    }

    public void setProducers(List<ProducerSummary> producers) {
        this.producers = producers;
    }

    public int getProducerCount() {
        return producerCount;
    }

    public void setProducerCount(int producerCount) {
        this.producerCount = producerCount;
    }
}
