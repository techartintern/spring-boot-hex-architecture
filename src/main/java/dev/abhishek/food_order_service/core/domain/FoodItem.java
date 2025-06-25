package dev.abhishek.food_order_service.core.domain;

import java.math.BigDecimal;

public record FoodItem(
        Integer id,
        String name,
        String category,
        BigDecimal price) {
}
