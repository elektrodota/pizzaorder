package hu.teamnamerequired.pizzaorder.service;

import hu.teamnamerequired.pizzaorder.dao.User;
import hu.teamnamerequired.pizzaorder.interfaces.UserService;
import hu.teamnamerequired.pizzaorder.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        final User currUser=userRepo.findById(user.getEmail()).get();
        return  userRepo.save(user);
    }

    @Override
    public void deleteUser(String email) {
        final User currUser=userRepo.findById(email).get();
        userRepo.delete(currUser);
    }
}
