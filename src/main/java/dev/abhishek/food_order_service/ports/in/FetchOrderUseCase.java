package dev.abhishek.food_order_service.ports.in;

import dev.abhishek.food_order_service.core.domain.Order;

public interface FetchOrderUseCase {
    Order findOrderById(Integer id);
}
