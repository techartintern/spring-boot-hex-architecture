package dev.abhishek.food_order_service.ports.out;

import java.util.Optional;

import dev.abhishek.food_order_service.core.domain.OrderItem;

public interface OrderItemDatabasePort {
    Optional<OrderItem> findById(Integer id);

    OrderItem save(OrderItem orderItem);
}
