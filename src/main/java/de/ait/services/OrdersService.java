package de.ait.services;

import de.ait.dto.OrderDto;

import java.util.List;

public interface OrdersService {
    List<String> getOrders();

    List<String> getOrdersWithoutIds();

    String makeOrder(OrderDto orderDto);
}
