package de.ait.repositories;

import de.ait.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersRepositoryListImpl implements OrdersRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public String save(Order order) {
        orders.add(order);
        return order.toString();
    }
}
