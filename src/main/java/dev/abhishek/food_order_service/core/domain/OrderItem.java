package dev.abhishek.food_order_service.core.domain;

import java.math.BigDecimal;

public record OrderItem(
        Integer id,
        FoodItem item,
        Integer quantity) {
    public BigDecimal subTotal() {
        return item.price().multiply(BigDecimal.valueOf(quantity));
    }
}
