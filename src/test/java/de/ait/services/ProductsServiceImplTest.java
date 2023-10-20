package de.ait.services;

import de.ait.repositories.ProductsRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsServiceImplTest {
    private ProductsServiceImpl productsService;

    @BeforeEach
    void setUp() {
        productsService = new ProductsServiceImpl(new ProductsRepositoryListImpl());
    }

    @Test
    void getCoffee() {
        List<String> actual = productsService.getCoffee();
        List<String> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void getCoffeeWithHighestRating() {
    }

    @Test
    void getCheapestCoffee() {
    }

    @Test
    void getMostExpensiveCoffee() {
    }

    @Test
    void getCoffeeLightRoastDegree() {
    }

    @Test
    void getCoffeeMiddleRoastDegree() {
    }

    @Test
    void getCoffeeDarkRoastDegree() {
    }

    @Test
    void getCoffeeFromCountry() {
    }

    @Test
    void getCoffeeSortedByRating() {
    }

    @Test
    void addCoffee() {
    }

    @Test
    void removeCoffeeById() {
    }
}