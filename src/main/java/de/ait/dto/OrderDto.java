package de.ait.dto;

public class OrderDto {
    private String productId;
    private String count;
    private String email;

    public OrderDto(String productId, String count, String email) {
        this.productId = productId;
        this.count = count;
        this.email = email;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", productId='" + productId + '\'' +
                ", count=" + count +
                ", email='" + email + '\'' +
                '}';
    }
}
