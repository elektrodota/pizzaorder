package hu.teamnamerequired.pizzaorder.repositories;

import hu.teamnamerequired.pizzaorder.dao.Pizza;
import hu.teamnamerequired.pizzaorder.dao.Rendeles;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface RendelesRepository extends CrudRepository<Rendeles,Long> {

    Collection<Rendeles> findAll();
    Optional<Rendeles> findById(Long Id);

}
