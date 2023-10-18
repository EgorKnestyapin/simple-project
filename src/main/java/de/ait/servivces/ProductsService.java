package de.ait.servivces;

import java.util.List;

public interface ProductsService {
    List<String> getCoffee();
    String getCoffeeWithHighestRating();
    String getCheapestCoffee();
}
