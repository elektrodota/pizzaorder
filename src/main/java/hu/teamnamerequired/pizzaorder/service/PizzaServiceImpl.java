package hu.teamnamerequired.pizzaorder.service;

import hu.teamnamerequired.pizzaorder.dao.Pizza;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import hu.teamnamerequired.pizzaorder.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    PizzaRepository pizzaRepo;

    // TODO: 2018. 11. 01. Pizza hozzáadása
    @Override
    public Pizza createPizza(Pizza pizza) {
        return null;
    }

    // TODO: 2018. 11. 01. Pizza szerkesztése
    @Override
    public Pizza updatePizza(Pizza pizza) {
        return null;
    }
    // TODO: 2018. 11. 01. Pizza törlése
    @Override
    public void deletePizza(Long id) {

    }
}
