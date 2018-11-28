package hu.teamnamerequired.pizzaorder.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableAutoConfiguration
public class LoginController {

    @RequestMapping(value = { "/Login.html" },method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView processLogin() {

        ModelAndView model = new ModelAndView();
        model.setViewName("Login");
        return model;

    }


}