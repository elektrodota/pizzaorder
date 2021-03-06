package hu.teamnamerequired.pizzaorder.controllers;

import hu.teamnamerequired.pizzaorder.dtos.PizzaCheckoutDto;
import hu.teamnamerequired.pizzaorder.dtos.PizzaDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class CheckOutController {

  /*  @GetMapping(value = "/Checkout", produces = MediaType.APPLICATION_JSON_VALUE, params = {"items"} )
    @ResponseBody
    public ModelAndView Index(@CookieValue("items") Collection<PizzaCheckoutDto> items) {

        ModelAndView model = new ModelAndView();
        model.addObject("items",items);
        model.setViewName("Checkout");
        return model;

    }
*/
    @GetMapping(value = "/Checkout")
    @ResponseBody
    public ModelAndView Index(@CookieValue(value="items", required=false) String items)
    {
        ModelAndView model=new ModelAndView();
        model.setViewName("Checkout");
        return model;
    }
}
