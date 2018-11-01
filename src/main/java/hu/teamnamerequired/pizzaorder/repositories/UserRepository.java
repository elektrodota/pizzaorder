package hu.teamnamerequired.pizzaorder.repositories;

import hu.teamnamerequired.pizzaorder.dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

}
