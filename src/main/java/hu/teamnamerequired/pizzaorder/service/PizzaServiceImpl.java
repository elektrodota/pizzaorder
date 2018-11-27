package hu.teamnamerequired.pizzaorder.service;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import hu.teamnamerequired.pizzaorder.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    PizzaRepository pizzaRepo;

    private final String PIZZA_NOT_FOUND = "Pizza id=%d not found";


    // TODO: 2018. 11. 01. Pizza hozzáadása
    @Override
    public Pizza createPizza(Pizza pizza) {
        return pizzaRepo.save(pizza);
    }

    // TODO: 2018. 11. 01. Pizza szerkesztése
    @Override
    public Pizza updatePizza(Pizza pizza) {
        try {
            Pizza pizzaToUpdate = pizzaRepo.findById(pizza.getId()).orElseThrow(() -> new PizzaNotFoundException(String.format(PIZZA_NOT_FOUND, pizza.getId())));
            pizzaRepo.save(pizzaToUpdate);
            return pizzaToUpdate;
        }catch (PizzaNotFoundException e){}
        return null;
    }
    // TODO: 2018. 11. 01. Pizza törlése
    @Override
    public void deletePizza(Long id) {
        try {
            Pizza pizzaToDelete = pizzaRepo.findById(id).orElseThrow(() -> new PizzaNotFoundException(String.format(PIZZA_NOT_FOUND, id)));
            pizzaRepo.delete(pizzaToDelete);
        }
        catch (PizzaNotFoundException e){}
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepo.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public List<Pizza> getPizzaByDescription(String description) {
        return pizzaRepo.findByTopping(description).stream().collect(Collectors.toList());
    }

    public class PizzaNotFoundException extends Exception {
        public PizzaNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
}
