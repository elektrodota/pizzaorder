package hu.teamnamerequired.pizzaorder.service;

import hu.teamnamerequired.pizzaorder.dtos.PizzaDto;
import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.entities.Rendeles;
import hu.teamnamerequired.pizzaorder.interfaces.RendelesService;
import hu.teamnamerequired.pizzaorder.repositories.RendelesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RendelesServiceImpl implements RendelesService {
    @Autowired
    RendelesRepository rendelesRepo;


    @Override
    public Rendeles createRendeles(Rendeles rendeles) {
        rendelesRepo.save(rendeles);
        return rendeles;
    }

    @Override
    public int totalPrice(Rendeles rendeles) {
        return 0; //rendeles.getPizzas().stream().mapToInt(p->p.getPizzaPrice()).sum();
    }

    /*
        // TODO: 2018. 11. 01. Rendelés szerkesztése
        @Override
        public Rendeles updateRendeles(Rendeles rendeles) {
            return null;
        }
    */
    @Override
    public void deleteRendeles(Long rendelesId) {
        rendelesRepo.deleteById(rendelesId);
    }
}
