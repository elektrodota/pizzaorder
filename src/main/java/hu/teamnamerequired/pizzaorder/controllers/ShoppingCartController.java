package hu.teamnamerequired.pizzaorder.controllers;


import hu.teamnamerequired.pizzaorder.dtos.PizzaDto;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableAutoConfiguration
public class ShoppingCartController {
    @Autowired
    PizzaService pizzaService;

    @GetMapping(value = "/shoppingCartController/api/getPizza", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PizzaDto getPizza(@RequestParam long id,HttpServletRequest httpServletRequest,Model uiModel) {
        System.out.println("itt vagyok");
        PizzaDto result = new PizzaDto(pizzaService.getPizzaById(id));
        return result;
    }
}
