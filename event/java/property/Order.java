package property;

import java.math.BigDecimal;

public class Order {

    private String client;
    private BigDecimal amount;
    private Status status;

    enum Status {
        DONE,
        PENDING
    }

    public Order(String client, BigDecimal amount, Status status) {
        this.client = client;
        this.amount = amount;
        this.status = status;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "client='" + client + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
