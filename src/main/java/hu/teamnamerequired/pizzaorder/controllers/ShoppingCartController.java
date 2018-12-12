package hu.teamnamerequired.pizzaorder.controllers;


import hu.teamnamerequired.pizzaorder.dtos.PizzaDto;
import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.enums.PizzaSize;
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

    private PizzaSize getSize(String size){
        switch(size)
        {
            case "32cm":
                return PizzaSize.Kicsi;
            case "42cm":
                return PizzaSize.Kozepes;
            case "52cm":
                return PizzaSize.Nagy;
            default:
                return PizzaSize.Kicsi;
        }
    }

    private int getPrice(Pizza pizza,PizzaSize size){
        switch(size)
        {
            case Kicsi:
                return pizza.getSmallPrice();
            case Kozepes:
                return pizza.getMidPrice();
            case Nagy:
                return pizza.getBigPrice();
            default:
                return pizza.getSmallPrice();
        }
    }

    @GetMapping(value = "/shoppingCartController/api/getPizza", produces = MediaType.APPLICATION_JSON_VALUE, params = {"id","size"} )
    @ResponseBody
    public PizzaDto getPizza(@RequestParam("id") long id,@RequestParam("size") String size,HttpServletRequest httpServletRequest,Model uiModel) {
        Pizza pizza = pizzaService.getPizzaById(id);
        PizzaSize pizzaSize = getSize(size);
        PizzaDto result = new PizzaDto(pizza,getPrice(pizza,pizzaSize),pizzaSize);
        return result;
    }
}
