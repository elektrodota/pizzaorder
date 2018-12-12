package hu.teamnamerequired.pizzaorder.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PizzaCheckoutDto {
    @Getter
    @Setter
    String itemid;
    @Getter
    @Setter
    PizzaDto pizza;

    public PizzaCheckoutDto(String itemid, PizzaDto pizza) {
        this.itemid = itemid;
        this.pizza = pizza;
    }
}
