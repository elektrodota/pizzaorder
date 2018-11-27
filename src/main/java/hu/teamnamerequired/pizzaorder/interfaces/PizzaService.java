package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.entities.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza createPizza(Pizza pizza);
    Pizza updatePizza(Pizza pizza);
    void deletePizza(Long Id);
    List<Pizza> getAllPizza();
    List<Pizza> getPizzaByDescription(String description);
}
