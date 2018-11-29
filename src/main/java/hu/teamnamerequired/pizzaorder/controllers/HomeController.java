package hu.teamnamerequired.pizzaorder.controllers;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.interfaces.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@EnableAutoConfiguration
public class HomeController {

    private static int currentPage = 1;
    private final static int pageSize = 6;

    @Autowired
    PizzaService pizzaService;

    @RequestMapping(value =  {"/"} , method = GET)
    @ResponseBody
    public ModelAndView welcomePage( @RequestParam(value = "filter",required = false) final Optional<String> filter,@RequestParam(value = "page") Optional<Integer> page) {
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
            pizzas = pizzaService.getAllPizza(filter.orElse(""));
        }

        page.ifPresent(p -> currentPage = p);
        Page<Pizza> pizzaPage = pizzaService.findPaginated(PageRequest.of(currentPage - 1, pageSize),filter.orElse(""));

        int totalPages = pizzaPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addObject("pageNumbers", pageNumbers);
        }

        model.addObject("pizzaPage", pizzaPage);
        model.addObject("currentPage", currentPage);
        model.addObject("currentYear",LocalDateTime.now().getYear());
        model.setViewName("Index.html");
        return model;
    }
}
