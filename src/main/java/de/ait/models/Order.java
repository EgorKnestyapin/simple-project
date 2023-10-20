package de.ait.models;

public class Order {
    private String id;
    private String productId;
    private int count;
    private String email;
    private double bill;

    public Order(String id, String productId, int count, String email, double bill) {
        this.id = id;
        this.productId = productId;
        this.count = count;
        this.email = email;
        this.bill = bill;
    }
}
