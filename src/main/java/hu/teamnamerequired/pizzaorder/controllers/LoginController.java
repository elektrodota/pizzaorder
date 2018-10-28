package hu.teamnamerequired.pizzaorder.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@EnableAutoConfiguration
public class LoginController {

//    @RequestMapping(value = "/greeting",method = GET)
//    @ResponseBody
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @RequestMapping(value = { "/", "/Login.html" },method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("Login");
        return model;

    }
}