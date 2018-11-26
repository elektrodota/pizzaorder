package hu.teamnamerequired.pizzaorder.controllers;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.repositories.PizzaRepository;
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

    PizzaRepository pizzaRepo;

    public HomeController(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @RequestMapping(value =  {"/"} , method = GET)
    @ResponseBody
    public ModelAndView welcomePage() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();

        if(auth.isAuthenticated()) {
            model.addObject("isUserLoggedIn", true);
            model.addObject("userName", auth.getName());
        }
        /*Pizza p1 = new Pizza();
        p1.setSmallPrice(5000);
        p1.setDescription("Teszt");
        p1.setName("Ananászos pizza");
        p1.setImage("/content/img/pizza-ananas-ev.jpg");

        Pizza p2 = new Pizza();
        p2.setSmallPrice(7000);
        p2.setDescription("Teszt2");
        p2.setName("Gombás pizza");
        p2.setImage("/content/img/pepperoni-pizza.jpg");

        Pizza p3 = new Pizza();
        p3.setSmallPrice(7000);
        p3.setDescription("Teszt2");
        p3.setName("Gombás pina");
        p3.setImage("/content/img/pepperoni-pizza.jpg");

        Pizza p4 = new Pizza();
        p4.setSmallPrice(7000);
        p4.setDescription("Teszt2");
        p4.setName("Gombás biga");
        p4.setImage("/content/img/pepperoni-pizza.jpg");
        */

        List<Pizza> test = pizzaRepo.findAll().stream().collect(Collectors.toList());





        model.setViewName("Index.html");
        model.addObject("pizzas", test);
        model.addObject("currentYear",LocalDateTime.now().getYear());
        return model;

    }
    @RequestMapping(value =  {"/"} ,params = "description", method = POST)
    @ResponseBody
    public ModelAndView welcomePage( @RequestParam String  description, @RequestParam String text) {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView();

        if(auth.isAuthenticated()) {
            model.addObject("isUserLoggedIn", true);
            model.addObject("userName", auth.getName());
        }
        /*Pizza p1 = new Pizza();
        p1.setSmallPrice(5000);
        p1.setDescription("Teszt");
        p1.setName("Ananászos pizza");
        p1.setImage("/content/img/pizza-ananas-ev.jpg");

        Pizza p2 = new Pizza();
        p2.setSmallPrice(7000);
        p2.setDescription("Teszt2");
        p2.setName("Gombás pizza");
        p2.setImage("/content/img/pepperoni-pizza.jpg");

        Pizza p3 = new Pizza();
        p3.setSmallPrice(7000);
        p3.setDescription("Teszt2");
        p3.setName("Gombás pina");
        p3.setImage("/content/img/pepperoni-pizza.jpg");

        Pizza p4 = new Pizza();
        p4.setSmallPrice(7000);
        p4.setDescription("Teszt2");
        p4.setName("Gombás biga");
        p4.setImage("/content/img/pepperoni-pizza.jpg");
        */

        List<Pizza> test = pizzaRepo.findByTopping(text).stream().collect(Collectors.toList());




        model.setViewName("Index.html");
        model.addObject("pizzas", test);
        model.addObject("currentYear",LocalDateTime.now().getYear());
        return model;

    }
}
