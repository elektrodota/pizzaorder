package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.dao.Pizza;
import hu.teamnamerequired.pizzaorder.service.PizzaServiceImpl;

public interface PizzaService {
    Pizza createPizza(Pizza pizza);
    Pizza updatePizza(Pizza pizza);
    void deletePizza(Long Id);
}
