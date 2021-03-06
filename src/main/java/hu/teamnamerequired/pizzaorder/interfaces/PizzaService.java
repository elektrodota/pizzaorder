package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PizzaService {
    Pizza createPizza(Pizza pizza);
    Pizza updatePizza(Pizza pizza);
    void deletePizza(Long Id);
    List<Pizza> getAllPizza();
    List<Pizza> getAllPizza(String filter);
    Pizza getPizzaById(long Id);
    List<Pizza> getPizzaByDescription(String description);
    Page<Pizza> findPaginated(Pageable pageable,String filter);
}
