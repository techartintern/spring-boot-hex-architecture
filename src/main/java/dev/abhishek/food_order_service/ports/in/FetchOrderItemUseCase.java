package dev.abhishek.food_order_service.ports.in;

import dev.abhishek.food_order_service.core.domain.OrderItem;

public interface FetchOrderItemUseCase {
    OrderItem findOrderById(Integer id);
}
