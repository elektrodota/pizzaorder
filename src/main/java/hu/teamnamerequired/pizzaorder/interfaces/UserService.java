package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.entities.User;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(String email);
}
