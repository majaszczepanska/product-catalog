package pl.majaszczepanska.product_catalog.analytics.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProducerSummary {

    private Long producerId;
    private String producerName;
    private BigDecimal totalRevenue;
    private int totalProducts;
    private Date lastProductDate;
    private Date producerSince;

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Date getLastProductDate() {
        return lastProductDate;
    }

    public void setLastProductDate(Date lastProductDate) {
        this.lastProductDate = lastProductDate;
    }

    public Date getProducerSince() {
        return producerSince;
    }

    public void setProducerSince(Date producerSince) {
        this.producerSince = producerSince;
    }
}
