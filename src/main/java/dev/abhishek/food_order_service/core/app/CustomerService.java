package dev.abhishek.food_order_service.core.app;

import org.springframework.stereotype.Service;

import dev.abhishek.food_order_service.core.domain.Customer;
import dev.abhishek.food_order_service.core.ports.primary.CreateCustomerUseCase;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService implements CreateCustomerUseCase {

    @Override
    public Customer create(String firstName, String lastName, String phone) {
        return new Customer(firstName, lastName, phone);
    }

}
