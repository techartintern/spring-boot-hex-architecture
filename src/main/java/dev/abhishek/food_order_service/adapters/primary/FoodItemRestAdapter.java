package dev.abhishek.food_order_service.adapters.primary;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.abhishek.food_order_service.core.domain.FoodItem;
import dev.abhishek.food_order_service.core.ports.primary.FetchFoodItemUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/fooditems")
@RequiredArgsConstructor
public class FoodItemRestAdapter {
    private final FetchFoodItemUseCase fetchFoodItemUseCase;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public FoodItem getMethodName(@PathVariable Integer id) {
        return fetchFoodItemUseCase.findFoodItemById(id);
    }

}
