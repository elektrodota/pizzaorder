package hu.teamnamerequired.pizzaorder.repositories;

import hu.teamnamerequired.pizzaorder.dao.Pizza;
import hu.teamnamerequired.pizzaorder.dao.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    Collection<User> findAll();
    Optional<User> findById(String Id);
}
