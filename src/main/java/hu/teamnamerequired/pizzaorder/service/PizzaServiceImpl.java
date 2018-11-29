package hu.teamnamerequired.pizzaorder.service;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import hu.teamnamerequired.pizzaorder.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
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
    public List<Pizza> getAllPizza(String filter) {
        final String f = filter.toLowerCase();
        return pizzaRepo.findAll().stream()
                .filter(p->p.getName().toLowerCase().contains(f) || p.getDescription().toLowerCase().contains(f))
                .collect(Collectors.toList());
    }

    @Override
    public Pizza getPizzaById(long Id) {
        try {
            return pizzaRepo.findById(Id).orElseThrow(() -> new PizzaNotFoundException(String.format(PIZZA_NOT_FOUND, Id)));
        }
        catch (PizzaNotFoundException e){}
        return null;
    }

    @Override
    public List<Pizza> getPizzaByDescription(String description) {
        return pizzaRepo.findByTopping(description).stream().collect(Collectors.toList());
    }

    @Override
    public Page<Pizza> findPaginated(Pageable pageable,String filter) {

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List<Pizza> pizzas = getAllPizza(filter);
        List<Pizza> list;

        if (pizzas.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, pizzas.size());
            list = pizzas.subList(startItem, toIndex);
        }

        Page<Pizza> pizzaPage = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), pizzas.size());

        return pizzaPage;
    }

    public class PizzaNotFoundException extends Exception {
        public PizzaNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
}
