package hu.teamnamerequired.pizzaorder.controllers;


import hu.teamnamerequired.pizzaorder.dtos.PizzaDto;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ShoppingCartController {
    @Autowired
    PizzaService pizzaService;

    @PostMapping(value = "/shoppingCartController/api/getPizza", produces = MediaType.APPLICATION_JSON_VALUE)
    public PizzaDto getPizza(@RequestBody long id,HttpServletRequest httpServletRequest,Model uiModel) {
        PizzaDto result = new PizzaDto(pizzaService.getPizzaById(id));
        return result;
    }
}
