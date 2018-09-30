package hu.teamnamerequired.pizzaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class PizzaorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaorderApplication.class, args);
    }
}
