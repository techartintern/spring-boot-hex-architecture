package dev.abhishek.food_order_service.core.ports.primary;

import dev.abhishek.food_order_service.core.domain.OrderItem;

public interface FetchOrderItemUseCase {
    OrderItem findOrderById(Integer id);
}
