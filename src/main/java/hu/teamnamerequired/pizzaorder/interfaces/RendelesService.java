package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.dao.Rendeles;

public interface RendelesService {
    Rendeles createUser(Rendeles rendeles);
    Rendeles updateUser(Rendeles rendeles);
    void deleteRendeles(Long rendelesId);
}
