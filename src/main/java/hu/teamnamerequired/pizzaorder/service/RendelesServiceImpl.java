package hu.teamnamerequired.pizzaorder.service;

import hu.teamnamerequired.pizzaorder.dao.Rendeles;
import hu.teamnamerequired.pizzaorder.interfaces.RendelesService;
import hu.teamnamerequired.pizzaorder.repositories.RendelesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RendelesServiceImpl implements RendelesService {
    @Autowired
    RendelesRepository rendelesRepo;

    // TODO: 2018. 11. 01. Rendelés hozzáadása
    @Override
    public Rendeles createRendeles(Rendeles rendeles) {
        return null;
    }

    // TODO: 2018. 11. 01. Rendelés szerkesztése
    @Override
    public Rendeles updateRendeles(Rendeles rendeles) {
        return null;
    }

    // TODO: 2018. 11. 01. Rendelés törlése
    @Override
    public void deleteRendeles(Long rendelesId) {

    }
}
