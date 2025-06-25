package dev.abhishek.food_order_service.ports.in;

import dev.abhishek.food_order_service.core.domain.Customer;

public interface CreateCustomerUseCase {
    Customer create(String firstName, String lastName, String phone);
}
