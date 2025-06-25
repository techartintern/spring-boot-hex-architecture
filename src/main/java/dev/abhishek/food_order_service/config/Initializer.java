package dev.abhishek.food_order_service.config;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.abhishek.food_order_service.core.domain.FoodItem;
import dev.abhishek.food_order_service.core.ports.secondary.FoodItemDatabasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class Initializer implements CommandLineRunner {

    private final FoodItemDatabasePort foodItemDatabasePort;

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        if (foodItemDatabasePort.findAll().isEmpty()) {
            final var data = IntStream.range(1, 21).mapToObj(
                    i -> new FoodItem(i, "Food" + i, "Category" + i, BigDecimal.valueOf(random.nextDouble())))
                    .map(foodItemDatabasePort::save).toList();
            data.forEach(d -> log.info("Created::{}", foodItemDatabasePort.save(d)));
            log.info("Data seeded");
        }
    }
}
