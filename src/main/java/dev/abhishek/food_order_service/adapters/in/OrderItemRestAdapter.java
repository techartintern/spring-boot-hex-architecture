package dev.abhishek.food_order_service.adapters.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhishek.food_order_service.core.domain.FoodItem;
import dev.abhishek.food_order_service.core.domain.OrderItem;
import dev.abhishek.food_order_service.ports.in.CreateOrderItemUseCase;
import dev.abhishek.food_order_service.ports.in.FetchOrderItemUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/orderitems")
@RequiredArgsConstructor
public class OrderItemRestAdapter {
    private final CreateOrderItemUseCase createOrderItemUseCase;
    private final FetchOrderItemUseCase fetchOrderItemUseCase;

    @PostMapping
    public OrderItem placeOrder(@RequestBody FoodItem foodItem, @RequestBody Integer quantity) {
        return createOrderItemUseCase.create(foodItem, quantity);
    }

    @GetMapping("{id}")
    public OrderItem fetch(@PathVariable Integer id) {
        return fetchOrderItemUseCase.findOrderById(id);
    }
}
