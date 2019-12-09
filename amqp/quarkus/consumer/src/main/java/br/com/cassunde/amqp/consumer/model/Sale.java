package br.com.cassunde.amqp.consumer.model;

import java.math.BigDecimal;

public class Sale {

    private String product;
    private BigDecimal value;
    private Integer amount;

    public Sale() {
    }

    public Sale(String product, BigDecimal value, Integer amount) {
        this.product = product;
        this.value = value;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "product='" + product + '\'' +
                ", value=" + value +
                ", amount=" + amount +
                '}';
    }
}
