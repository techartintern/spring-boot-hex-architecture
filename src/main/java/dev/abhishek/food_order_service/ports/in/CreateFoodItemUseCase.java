package dev.abhishek.food_order_service.ports.in;

import java.math.BigDecimal;

import dev.abhishek.food_order_service.core.domain.FoodItem;

public interface CreateFoodItemUseCase {
    FoodItem create(String name, String category, BigDecimal price);
}
