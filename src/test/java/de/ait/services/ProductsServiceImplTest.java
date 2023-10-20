package de.ait.services;

import de.ait.dto.ProductDto;
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
        List<String> expected = List.of(
                "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0",
                "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2"
        );
        assertEquals(expected, actual);
    }

    @Test
    void getCoffeeWithHighestRating() {
        String actual = productsService.getCoffeeWithHighestRating();
        String expected = "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1";
        assertEquals(expected, actual);
    }

    @Test
    void getCheapestCoffee() {
        String actual = productsService.getCheapestCoffee();
        String expected = "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2";
        assertEquals(expected, actual);
    }

    @Test
    void getMostExpensiveCoffee() {
        String actual = productsService.getMostExpensiveCoffee();
        String expected = "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1";
        assertEquals(expected, actual);
    }

    @Test
    void getCoffeeLightRoastDegree() {
        List<String> actual = productsService.getCoffeeLightRoastDegree();
        List<String> expected = List.of(
                "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1"
        );
        assertEquals(expected, actual);
    }

    @Test
    void getCoffeeMiddleRoastDegree() {
        List<String> actual = productsService.getCoffeeMiddleRoastDegree();
        List<String> expected = List.of(
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
        );
        assertEquals(expected, actual);
    }

    @Test
    void getCoffeeDarkRoastDegree() {
        List<String> actual = productsService.getCoffeeDarkRoastDegree();
        List<String> expected = List.of(
                "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2"
        );
        assertEquals(expected, actual);
    }

    @Test
    void getCoffeeFromCountry() {
        List<String> actual = productsService.getCoffeeFromCountry("Columbia");
        List<String> expected = List.of(
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
        );
        assertEquals(expected, actual);
    }

    @Test
    void getCoffeeSortedByRating() {
        List<String> actual = productsService.getCoffeeSortedByRating();
        List<String> expected = List.of(
                "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0",
                "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2"
        );
        assertEquals(expected, actual);
    }

    @Test
    void addCoffee() {
        productsService.addCoffee(new ProductDto("Nicaragua", "DARK", "ARABICA", "4.4", "3.0", "true"));
        List<String> actual = productsService.getCoffee();
        List<String> expected = List.of(
                "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0",
                "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2",
                "\nСтрана: Nicaragua, сорт кофе: ARABICA, степень обжарки: DARK, цена за 100 гр.: 4.4, рейтинг: 3.0"
        );
        assertEquals(expected, actual);
    }

    @Test
    void removeCoffeeById() {
    }
}