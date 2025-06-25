package dev.abhishek.food_order_service.ports.in;

import java.util.Set;

import dev.abhishek.food_order_service.core.domain.Customer;
import dev.abhishek.food_order_service.core.domain.Order;
import dev.abhishek.food_order_service.core.domain.OrderItem;

public interface CreateOrderUseCase {

    Order placeOrder(Customer customer, Set<OrderItem> orderItems);
}
