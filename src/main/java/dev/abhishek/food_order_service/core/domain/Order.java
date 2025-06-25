package dev.abhishek.food_order_service.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record Order(
        Integer id,
        Customer customer,
        Set<OrderItem> orderItems,
        LocalDate orderDate,
        OrderStatus orderStatus) {

    public Order(Integer id, Customer customer, Set<OrderItem> orderItems) {
        this(id, customer, orderItems, LocalDate.now(), OrderStatus.READY);
    }

    public BigDecimal total() {
        return orderItems.stream().map(OrderItem::subTotal).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    public Order cancelOrder() {
        return new Order(this.id, this.customer, this.orderItems, this.orderDate, OrderStatus.CANCELLED);
    }

    public Order compeleteOrder() {
        return new Order(this.id, this.customer, this.orderItems, this.orderDate, OrderStatus.COMPELETED);
    }
}
