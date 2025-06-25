package dev.abhishek.food_order_service.core.ports.secondary;

import java.util.Optional;

import dev.abhishek.food_order_service.core.domain.Order;

public interface OrderDatabasePort {
    Optional<Order> findById(Integer id);

    Order save(Order order);

}
