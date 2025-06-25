package dev.abhishek.food_order_service.adapters.out.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.abhishek.food_order_service.core.domain.OrderItem;
import dev.abhishek.food_order_service.ports.out.OrderItemDatabasePort;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@NoArgsConstructor
@Slf4j
public class InMemoryOrderItemDatabaseAdapter implements OrderItemDatabasePort {
    private static Integer count = 0;
    private final Map<Integer, OrderItem> store = new HashMap<>();

    @Override
    public OrderItem save(OrderItem orderItem) {
        if (null == orderItem.id()) {
            count++;
            store.put(count, orderItem);
            return new OrderItem(count, orderItem.item(), orderItem.quantity());
        }
        store.put(orderItem.id(), orderItem);
        log.info("Saved OrderItem to In Memory DB::{}", orderItem.id());
        return store.get(orderItem.id());
    }

    @Override
    public Optional<OrderItem> findById(Integer id) {
        if (null == id || id < 1) {
            log.warn("Null key used to fetch OrderItem.");
            return Optional.empty();
        }
        final var found = Optional.ofNullable(store.get(id));
        log.info("Found in DB::{}", found);
        return found;
    }

}
