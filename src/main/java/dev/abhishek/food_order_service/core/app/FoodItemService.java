package dev.abhishek.food_order_service.core.app;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.abhishek.food_order_service.core.domain.FoodItem;
import dev.abhishek.food_order_service.core.ports.primary.CreateFoodItemUseCase;
import dev.abhishek.food_order_service.core.ports.primary.FetchFoodItemUseCase;
import dev.abhishek.food_order_service.core.ports.secondary.FoodItemDatabasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodItemService implements FetchFoodItemUseCase, CreateFoodItemUseCase {

    private final FoodItemDatabasePort foodItemDatabasePort;

    @Override
    public FoodItem create(String name, String category, BigDecimal price) {
        final FoodItem foodItem = new FoodItem(null, name, category, price);
        return foodItemDatabasePort.save(foodItem);
    }

    @Override
    public FoodItem findFoodItemById(Integer id) {

        log.info("Fetching FoodItem with id::{}", id);
        if (null == id || id < 1) {
            throw new IllegalStateException("Id should be positive.");
        }

        final Optional<FoodItem> foodItemOpt = foodItemDatabasePort.findById(id);
        final FoodItem foodItem = foodItemOpt.orElseThrow(() -> {
            log.warn("FoodItem not found in db.");
            return new IllegalStateException("FoodItem not found in db.");
        });
        log.info("Found::{}", foodItem);
        return foodItem;
    }

}
