package dev.abhishek.food_order_service.core.app;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dev.abhishek.food_order_service.core.domain.Customer;
import dev.abhishek.food_order_service.core.domain.Order;
import dev.abhishek.food_order_service.core.domain.OrderItem;
import dev.abhishek.food_order_service.core.ports.primary.CreateOrderUseCase;
import dev.abhishek.food_order_service.core.ports.primary.FetchOrderUseCase;
import dev.abhishek.food_order_service.core.ports.secondary.OrderDatabasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements CreateOrderUseCase, FetchOrderUseCase {
    private final OrderDatabasePort orderDatabasePort;

    @Override
    public Order placeOrder(Customer customer, Set<OrderItem> orderItems) {
        final Order order = new Order(null, customer, orderItems);
        return orderDatabasePort.save(order);
    }

    @Override
    public Order findOrderById(Integer id) {

        log.info("Fetching Order with id::{}", id);
        if (null == id || id < 1) {
            throw new IllegalStateException("Id should be positive.");
        }

        final Optional<Order> orderOpt = orderDatabasePort.findById(id);
        final Order order = orderOpt.orElseThrow(() -> {
            log.warn("Order not found in db.");
            return new IllegalStateException("Order not found in db.");
        });
        log.info("Found::{}", order);
        return order;
    }

}
