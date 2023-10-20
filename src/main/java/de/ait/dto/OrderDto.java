package de.ait.dto;

public class OrderDto {
    private String productId;
    private int count;
    private String email;
    private double bill;

    public OrderDto(String productId, int count, String email, double bill) {
        this.productId = productId;
        this.count = count;
        this.email = email;
        this.bill = bill;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", productId='" + productId + '\'' +
                ", count=" + count +
                ", email='" + email + '\'' +
                ", bill=" + bill +
                '}';
    }
}
