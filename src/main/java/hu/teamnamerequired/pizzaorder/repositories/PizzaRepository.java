package hu.teamnamerequired.pizzaorder.repositories;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface PizzaRepository extends CrudRepository<Pizza,Long> {

    Collection<Pizza> findAll();
    Optional<Pizza> findById(Long Id);

}
