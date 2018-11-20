package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.entities.Pizza;

public interface PizzaService {
    Pizza createPizza(Pizza pizza);
    Pizza updatePizza(Pizza pizza);
    void deletePizza(Long Id);
}
