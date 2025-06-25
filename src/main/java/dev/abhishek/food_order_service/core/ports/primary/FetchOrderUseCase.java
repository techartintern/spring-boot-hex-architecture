package dev.abhishek.food_order_service.core.ports.primary;

import dev.abhishek.food_order_service.core.domain.Order;

public interface FetchOrderUseCase {
    Order findOrderById(Integer id);
}
