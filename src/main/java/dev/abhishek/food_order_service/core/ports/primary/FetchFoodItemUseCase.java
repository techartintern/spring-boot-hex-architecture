package dev.abhishek.food_order_service.core.ports.primary;

import dev.abhishek.food_order_service.core.domain.FoodItem;

public interface FetchFoodItemUseCase {
    FoodItem findFoodItemById(Integer id);
}
