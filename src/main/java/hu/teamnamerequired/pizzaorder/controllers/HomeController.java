package hu.teamnamerequired.pizzaorder.controllers;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import hu.teamnamerequired.pizzaorder.repositories.PizzaRepository;
import hu.teamnamerequired.pizzaorder.service.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@EnableAutoConfiguration
public class HomeController {
    @Autowired
    PizzaService pizzaService;

    @RequestMapping(value =  {"/"} , method = GET)
    @ResponseBody
    public ModelAndView welcomePage( @RequestParam(value = "filter",required = false) final String filter) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();
        List<Pizza> pizzas;
        if(!auth.getName().equalsIgnoreCase("anonymousUser")) {
            model.addObject("isUserLoggedIn", true);
            model.addObject("userName", auth.getName());
        }
        if(null == filter){
            pizzas = pizzaService.getAllPizza();
        }
        else{
            pizzas = pizzaService.getPizzaByDescription(filter);
        }

        model.setViewName("Index.html");
        model.addObject("pizzas", pizzas);
        model.addObject("currentYear",LocalDateTime.now().getYear());
        return model;

    }
}
