package de.ait.services;

import de.ait.dto.OrderDto;

import java.util.List;

public interface OrdersService {
    List<String> getOrders();
    String makeOrder(OrderDto orderDto);
}
