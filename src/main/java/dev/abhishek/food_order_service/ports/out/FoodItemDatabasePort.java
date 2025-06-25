package dev.abhishek.food_order_service.ports.out;

import java.util.List;
import java.util.Optional;

import dev.abhishek.food_order_service.core.domain.FoodItem;

public interface FoodItemDatabasePort {

    Optional<FoodItem> findById(Integer id);

    FoodItem save(FoodItem foodItem);

    List<FoodItem> findAll();
}
