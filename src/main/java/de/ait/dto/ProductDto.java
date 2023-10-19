package de.ait.dto;

import de.ait.models.CoffeeType;
import de.ait.models.RoastDegree;

public class ProductDto {
    private String roastDegree;
    private String coffeeType;
    private String country;
    private String pricePer100Gr;
    private String rating;
    private String isAvailable;

    public ProductDto(String country, String roastDegree, String coffeeType, String pricePer100Gr, String rating,
                      String isAvailable) {
        this.roastDegree = roastDegree;
        this.coffeeType = coffeeType;
        this.country = country;
        this.pricePer100Gr = pricePer100Gr;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public String getRoastDegree() {
        return roastDegree;
    }

    public void setRoastDegree(String roastDegree) {
        this.roastDegree = roastDegree;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPricePer100Gr() {
        return pricePer100Gr;
    }

    public void setPricePer100Gr(String pricePer100Gr) {
        this.pricePer100Gr = pricePer100Gr;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String isAvailable() {
        return isAvailable;
    }

    public void setAvailable(String available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "\nroastDegree=" + roastDegree +
                ", coffeeType=" + coffeeType +
                ", country='" + country + '\'' +
                ", pricePer100Gr=" + pricePer100Gr +
                ", rating=" + rating;
    }
}
