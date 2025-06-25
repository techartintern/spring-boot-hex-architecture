package dev.abhishek.food_order_service.adapters.primary;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhishek.food_order_service.core.domain.Customer;
import dev.abhishek.food_order_service.core.domain.Order;
import dev.abhishek.food_order_service.core.domain.OrderItem;
import dev.abhishek.food_order_service.core.ports.primary.CreateOrderUseCase;
import dev.abhishek.food_order_service.core.ports.primary.FetchOrderUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderRestAdapter {

    private final CreateOrderUseCase createOrderUseCase;
    private final FetchOrderUseCase fetchOrderUseCase;

    @PostMapping
    public Order placeOrder(@RequestBody Customer customer, @RequestBody Set<OrderItem> orderItems) {
        return createOrderUseCase.placeOrder(customer, orderItems);
    }

    @GetMapping("{id}")
    public Order fetch(@PathVariable Integer id) {
        return fetchOrderUseCase.findOrderById(id);
    }

}
