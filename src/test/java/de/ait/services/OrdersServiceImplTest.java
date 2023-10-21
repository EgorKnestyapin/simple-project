package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.models.CoffeeType;
import de.ait.models.Product;
import de.ait.models.RoastDegree;
import de.ait.repositories.OrdersRepositoryListImpl;
import de.ait.repositories.ProductsRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdersServiceImplTest {
    private ProductsService productsService = new ProductsServiceImpl(new ProductsRepositoryListImpl(new ArrayList<>(List.of(
            new Product("brazilId", "Brazil", RoastDegree.LIGHT, CoffeeType.ARABICA,
                    5.5, 4.1, true),
            new Product("jordanId", "Jordan", RoastDegree.DARK, CoffeeType.ROBUSTA,
                    2, 3.2, true),
            new Product("columbiaId", "Columbia", RoastDegree.MIDDLE, CoffeeType.HYBRID,
                    4, 4, true),
            new Product("kenyaId", "Kenya", RoastDegree.LIGHT, CoffeeType.DECAF,
                    4.8, 3.8, false)))));
    private OrdersService ordersService;

    @BeforeEach
    void setUp() {
        ordersService = new OrdersServiceImpl(new OrdersRepositoryListImpl(), productsService);
    }

    @Test
    void getOrders() {
        List<String> actual = ordersService.getOrders();
        List<String> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void makeOrder() {
        List<String> actual = ordersService.getOrders();
        List<String> expected = List.of();
        assertEquals(expected, actual);
        ordersService.makeOrder(new OrderDto("jordanId", "5", "john@gmail.com"));
        actual = ordersService.getOrdersWithoutIds();
        expected = List.of(
                "\nВаш заказ:\nId продукта: jordanId, количество: 5"
                        + "\nОбщий счет: 10.0, чек отправлен на email: john@gmail.com"
        );
        assertEquals(expected, actual);
    }
}