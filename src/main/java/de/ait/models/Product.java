package de.ait.models;

public class Product {
    private String productId;
    private RoastDegree roastDegree;
    private CoffeeType coffeeType;
    private String country;
    private double pricePer100Gr;
    private double rating;
    private boolean isAvailable;

    public Product(String productId, String country, RoastDegree roastDegree, CoffeeType coffeeType, double pricePer100Gr, double rating, boolean isAvailable) {
        this.productId = productId;
        this.roastDegree = roastDegree;
        this.coffeeType = coffeeType;
        this.country = country;
        this.pricePer100Gr = pricePer100Gr;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public RoastDegree getRoastDegree() {
        return roastDegree;
    }

    public void setRoastDegree(RoastDegree roastDegree) {
        this.roastDegree = roastDegree;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPricePer100Gr() {
        return pricePer100Gr;
    }

    public void setPricePer100Gr(double pricePer100Gr) {
        this.pricePer100Gr = pricePer100Gr;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "\nproductId='" + productId + '\'' +
                ", roastDegree=" + roastDegree +
                ", coffeeType=" + coffeeType +
                ", country='" + country + '\'' +
                ", pricePer100Gr=" + pricePer100Gr +
                ", rating=" + rating;
    }
}
