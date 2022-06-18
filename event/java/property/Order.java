package property;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {

    private String client;
    private BigDecimal amount;
    private String status;

    public Order(String client, BigDecimal amount) {
        this.client = client;
        this.amount = amount;
        this.status = "PENDING";
    }

    public String getClient() {
        return client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void updateStatus(String status){
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, amount, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "client='" + client + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
