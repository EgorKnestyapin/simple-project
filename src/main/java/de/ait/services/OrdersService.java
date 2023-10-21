package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.models.Product;

import java.util.List;

public interface OrdersService {
    List<String> getOrders();

    List<String> getOrdersWithoutIds();

    String makeOrder(OrderDto orderDto, Product product);
}
