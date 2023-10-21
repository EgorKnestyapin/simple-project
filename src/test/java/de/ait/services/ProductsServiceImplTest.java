package de.ait.services;

import de.ait.dto.ProductDto;
import de.ait.models.CoffeeType;
import de.ait.models.Product;
import de.ait.models.RoastDegree;
import de.ait.repositories.ProductsRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsServiceImplTest {
    private ProductsServiceImpl productsService;

    private ProductsServiceImpl productsServiceCustomIds;

    @BeforeEach
    void setUp() {
        productsService = new ProductsServiceImpl(new ProductsRepositoryListImpl());
        productsServiceCustomIds = new ProductsServiceImpl(new ProductsRepositoryListImpl(new ArrayList<>(List.of(
                new Product("brazilId", "Brazil", RoastDegree.LIGHT, CoffeeType.ARABICA,
                        5.5, 4.1, true),
                new Product("jordanId", "Jordan", RoastDegree.DARK, CoffeeType.ROBUSTA,
                        2, 3.2, true),
                new Product("columbiaId", "Columbia", RoastDegree.MIDDLE, CoffeeType.HYBRID,
                        4, 4, true),
                new Product("kenyaId", "Kenya", RoastDegree.LIGHT, CoffeeType.DECAF,
                        4.8, 3.8, false)
        ))));
    }

    @Test
    void getCoffeeWithoutIds() {
        List<String> actual = productsService.getCoffeeWithoutIds();
        List<String> expected = List.of(
                "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2",
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
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
        List<String> actual = productsService.getCoffeeWithoutIds();
        List<String> expected = List.of(
                "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2",
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
        );
        assertEquals(expected, actual);
        productsService.addCoffee(new ProductDto("Nicaragua", "DARK", "ARABICA", "4.4", "3.0", "true"));
        actual = productsService.getCoffeeWithoutIds();
        expected = List.of(
                "\nСтрана: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nСтрана: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2",
                "\nСтрана: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0",
                "\nСтрана: Nicaragua, сорт кофе: ARABICA, степень обжарки: DARK, цена за 100 гр.: 4.4, рейтинг: 3.0"
        );
        assertEquals(expected, actual);
    }

    @Test
    void updateProductStatus() {
        List<String> actual = productsServiceCustomIds.getCoffee();
        List<String> expected = List.of(
                "\nId продукта: brazilId, страна: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nId продукта: jordanId, страна: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2",
                "\nId продукта: columbiaId, страна: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
        );
        assertEquals(expected, actual);
        productsServiceCustomIds.updateProductStatus("jordanId");
        boolean actualStatus = productsServiceCustomIds.findById("jordanId").isAvailable();
        boolean expectedStatus = false;
        assertEquals(expectedStatus, actualStatus);
        actual = productsServiceCustomIds.getCoffee();
        expected = List.of(
                "\nId продукта: brazilId, страна: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nId продукта: columbiaId, страна: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
        );
        assertEquals(expected, actual);
    }

    @Test
    void removeCoffeeById() {
        List<String> actual = productsServiceCustomIds.getCoffee();
        List<String> expected = List.of(
                "\nId продукта: brazilId, страна: Brazil, сорт кофе: ARABICA, степень обжарки: LIGHT, цена за 100 гр.: 5.5, рейтинг: 4.1",
                "\nId продукта: jordanId, страна: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2",
                "\nId продукта: columbiaId, страна: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
        );
        assertEquals(expected, actual);
        productsServiceCustomIds.removeCoffeeById("brazilId");
        actual = productsServiceCustomIds.getCoffee();
        expected = List.of(
                "\nId продукта: jordanId, страна: Jordan, сорт кофе: ROBUSTA, степень обжарки: DARK, цена за 100 гр.: 2.0, рейтинг: 3.2",
                "\nId продукта: columbiaId, страна: Columbia, сорт кофе: HYBRID, степень обжарки: MIDDLE, цена за 100 гр.: 4.0, рейтинг: 4.0"
        );
        assertEquals(expected, actual);
    }
}