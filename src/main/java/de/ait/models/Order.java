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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "\nId заказа: " + getId() + "\nId продукта: " + getProductId() + ", количество: " + getCount()
                + "\nОбщий счет: " + getBill() + ", чек отправлен на email: " + getEmail();
    }
}