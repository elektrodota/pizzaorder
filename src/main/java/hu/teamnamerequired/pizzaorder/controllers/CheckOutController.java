package hu.teamnamerequired.pizzaorder.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableAutoConfiguration
public class CheckOutController {

    @RequestMapping(value = { "/Checkout" },method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView Index() {

        ModelAndView model = new ModelAndView();
        model.setViewName("Checkout");
        return model;

    }

}
