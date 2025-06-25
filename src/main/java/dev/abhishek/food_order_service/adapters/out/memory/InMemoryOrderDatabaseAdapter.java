package dev.abhishek.food_order_service.adapters.out.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.abhishek.food_order_service.core.domain.Order;
import dev.abhishek.food_order_service.ports.out.OrderDatabasePort;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@NoArgsConstructor
@Slf4j
public class InMemoryOrderDatabaseAdapter implements OrderDatabasePort {
    private static Integer count = 0;
    private final Map<Integer, Order> store = new HashMap<>();

    @Override
    public Order save(Order order) {
        if (null == order.id()) {
            count++;
            store.put(count, order);
            return new Order(count, order.customer(), order.orderItems());
        }
        store.put(order.id(), order);
        log.info("Saved Order to In Memory DB::{}", order.id());
        return store.get(order.id());
    }

    @Override
    public Optional<Order> findById(Integer id) {
        if (null == id || id < 1) {
            log.warn("Null key used to fetch Order.");
            return Optional.empty();
        }
        final var found = Optional.ofNullable(store.get(id));
        log.info("Found in DB::{}", found);
        return found;
    }

}
