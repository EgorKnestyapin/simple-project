package de.ait.repositories;

import de.ait.models.Order;

import java.util.List;

public interface OrdersRepository {
    List<Order> findAll();
    String save(Order order);
}
