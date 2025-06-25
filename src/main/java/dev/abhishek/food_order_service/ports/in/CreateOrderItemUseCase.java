package dev.abhishek.food_order_service.ports.in;

import dev.abhishek.food_order_service.core.domain.FoodItem;
import dev.abhishek.food_order_service.core.domain.OrderItem;

public interface CreateOrderItemUseCase {
    OrderItem create(FoodItem food, Integer quantity);
}
