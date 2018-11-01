package hu.teamnamerequired.pizzaorder.repositories;

import hu.teamnamerequired.pizzaorder.dao.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza,Long> {
}
