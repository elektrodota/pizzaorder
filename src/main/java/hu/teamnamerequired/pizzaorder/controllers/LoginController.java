package hu.teamnamerequired.pizzaorder.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableAutoConfiguration
public class LoginController {

//    @RequestMapping(value = "/greeting",method = GET)
//    @ResponseBody
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @RequestMapping(value = { "/Login.html" },method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("Login");
        return model;

    }


}