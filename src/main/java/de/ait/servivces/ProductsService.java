package de.ait.servivces;

import de.ait.dto.ProductDto;

import java.util.List;

public interface ProductsService {
    List<String> getCoffee();

    String getCoffeeWithHighestRating();

    String getCheapestCoffee();

    String getMostExpensiveCoffee();

    List<String> getCoffeeLightRoastDegree();

    List<String> getCoffeeMiddleRoastDegree();

    List<String> getCoffeeDarkRoastDegree();

    List<String> getCoffeeFromCountry();

    List<String> getCoffeeSortedByRating();

    String addCoffee(ProductDto productDto);
}
