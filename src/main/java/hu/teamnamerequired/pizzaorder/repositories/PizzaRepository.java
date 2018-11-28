package hu.teamnamerequired.pizzaorder.repositories;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface PizzaRepository extends CrudRepository<Pizza,Long> {

    Collection<Pizza> findAll();
    Optional<Pizza> findById(Long Id);
    @Modifying
    @Query("from Pizza p where  LOWER(p.Description) LIKE   LOWER(CONCAT('%',:topping,'%'))")
    Collection<Pizza> findByTopping(@Param("topping") String topping);

}
