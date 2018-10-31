package hu.teamnamerequired.pizzaorder.controllers;

import hu.teamnamerequired.pizzaorder.resources.Greeting;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@EnableAutoConfiguration
public class HomeController {

//    @RequestMapping(value = "/greeting",method = GET)
//    @ResponseBody
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @RequestMapping(value =  {"/","/welcome"} , method = GET)
    @ResponseBody
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("Home.html");
        model.addObject("greeting","asd");
        return model;

    }
}
