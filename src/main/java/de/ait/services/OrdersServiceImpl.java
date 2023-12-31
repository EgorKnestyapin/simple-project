package de.ait.services;

import de.ait.dto.OrderDto;
import de.ait.models.Order;
import de.ait.models.Product;
import de.ait.repositories.OrdersRepository;

import java.util.List;
import java.util.UUID;

public class OrdersServiceImpl implements OrdersService {
    OrdersRepository orderRepository;

    public OrdersServiceImpl(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<String> getOrders() {
        return orderRepository.findAll().stream()
                .map(Order::toString)
                .toList();
    }

    @Override
    public List<String> getOrdersWithoutIds() {
        return orderRepository.findAll().stream()
                .map(order -> "\nВаш заказ:" + "\nId продукта: " + order.getProductId() + ", количество: "
                        + order.getCount() + "\nОбщий счет: " + order.getBill() + ", чек отправлен на email: "
                        + order.getEmail())
                .toList();
    }

    @Override
    public String makeOrder(OrderDto orderDto, Product product) {
        if (product == null) return "Такого товара нет в наличии";
        int count = Integer.parseInt(orderDto.getCount());
        double bill = count * product.getPricePer100Gr();
        Order order = new Order(UUID.randomUUID().toString(), orderDto.getProductId(), count, orderDto.getEmail(),
                bill);
        return orderRepository.save(order);
    }
}
