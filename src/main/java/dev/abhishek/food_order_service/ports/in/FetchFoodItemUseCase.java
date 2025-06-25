package dev.abhishek.food_order_service.ports.in;

import dev.abhishek.food_order_service.core.domain.FoodItem;

public interface FetchFoodItemUseCase {
    FoodItem findFoodItemById(Integer id);
}
