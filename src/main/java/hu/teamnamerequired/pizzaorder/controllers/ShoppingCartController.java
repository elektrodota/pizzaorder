package hu.teamnamerequired.pizzaorder.controllers;


import hu.teamnamerequired.pizzaorder.dtos.PizzaDto;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
    @Autowired
    PizzaService pizzaService;

    @ResponseBody
    @RequestMapping(value = "/shoppingController/api/getPizza")
    public PizzaDto getSearchResultViaAjax(@RequestBody long id) {
        PizzaDto result = new PizzaDto(pizzaService.getPizzaById(id));
        return result;
    }
}
