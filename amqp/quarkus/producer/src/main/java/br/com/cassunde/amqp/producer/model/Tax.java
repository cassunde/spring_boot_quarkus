package br.com.cassunde.amqp.producer.model;

import java.math.BigDecimal;

public class Tax {

    private BigDecimal finalValue;
    private Sale sale;

    public Tax(Sale sale) {
        this.finalValue = sale.getValue().multiply(new BigDecimal("0.10"));
        this.sale = sale;
    }

    public BigDecimal getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(BigDecimal finalValue) {
        this.finalValue = finalValue;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
