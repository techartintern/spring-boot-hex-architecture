package dev.abhishek.food_order_service.adapters.out.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.abhishek.food_order_service.core.domain.FoodItem;
import dev.abhishek.food_order_service.ports.out.FoodItemDatabasePort;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@NoArgsConstructor
@Slf4j
public class InMemoryFoodItemDatabaseAdapter implements FoodItemDatabasePort {
    private static Integer count = 0;
    private final Map<Integer, FoodItem> store = new HashMap<>();

    @Override
    public Optional<FoodItem> findById(Integer id) {
        if (null == id || id < 1) {
            log.warn("Null key used to fetch FoodItem.");
            return Optional.empty();
        }
        final var found = Optional.ofNullable(store.get(id));
        log.info("Found in DB::{}", found);
        return found;
    }

    @Override
    public FoodItem save(FoodItem foodItem) {
        if (null == foodItem.id()) {
            count++;
            store.put(count, foodItem);
            return new FoodItem(count, foodItem.name(), foodItem.category(), foodItem.price());
        }
        store.put(foodItem.id(), foodItem);
        log.info("Saved FoodItem to In Memory DB::{}", foodItem.id());
        return store.get(foodItem.id());
    }

    @Override
    public List<FoodItem> findAll() {
        return new ArrayList<>(store.values());
    }

}
