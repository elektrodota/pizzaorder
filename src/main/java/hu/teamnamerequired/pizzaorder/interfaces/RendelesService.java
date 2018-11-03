package hu.teamnamerequired.pizzaorder.interfaces;

import hu.teamnamerequired.pizzaorder.dao.Rendeles;

public interface RendelesService {
    Rendeles createRendeles(Rendeles rendeles);
    Rendeles updateRendeles(Rendeles rendeles);
    void deleteRendeles(Long rendelesId);
}
