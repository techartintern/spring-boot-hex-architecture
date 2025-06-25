package dev.abhishek.food_order_service.core.app;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.abhishek.food_order_service.core.domain.FoodItem;
import dev.abhishek.food_order_service.core.domain.OrderItem;
import dev.abhishek.food_order_service.ports.in.CreateOrderItemUseCase;
import dev.abhishek.food_order_service.ports.in.FetchOrderItemUseCase;
import dev.abhishek.food_order_service.ports.out.OrderItemDatabasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemService implements CreateOrderItemUseCase, FetchOrderItemUseCase {
    private final OrderItemDatabasePort orderItemDatabasePort;

    @Override
    public OrderItem create(FoodItem food, Integer quantity) {
        OrderItem orderItem = new OrderItem(null, food, quantity);
        return orderItemDatabasePort.save(orderItem);
    }

    @Override
    public OrderItem findOrderById(Integer id) {

        log.info("Fetching OrderItem with id::{}", id);
        if (null == id || id < 1) {
            throw new IllegalStateException("Id should be positive.");
        }

        final Optional<OrderItem> orderItemOpt = orderItemDatabasePort.findById(id);
        final OrderItem orderItem = orderItemOpt.orElseThrow(() -> {
            log.warn("OrderItem not found in db.");
            return new IllegalStateException("OrderItem not found in db.");
        });
        log.info("Found::{}", orderItem);
        return orderItem;
    }

}
