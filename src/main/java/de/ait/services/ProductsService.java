package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.dto.ProductDto;
import de.ait.models.Product;

import java.util.List;

public interface ProductsService {
    List<String> getCoffee();

    List<String> getCoffeeWithoutIds();

    String getCoffeeWithHighestRating();

    String getCheapestCoffee();

    String getMostExpensiveCoffee();

    List<String> getCoffeeLightRoastDegree();

    List<String> getCoffeeMiddleRoastDegree();

    List<String> getCoffeeDarkRoastDegree();

    List<String> getCoffeeFromCountry(String country);

    List<String> getCoffeeSortedByRating();

    Product findById(String id);

    String addCoffee(ProductDto productDto);

    List<String> updateProductStatus(String id);

    Product removeCoffeeById(String id);
}
