package hu.teamnamerequired.pizzaorder.entities;

import hu.teamnamerequired.pizzaorder.enums.PizzaSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class PizzaGroup{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    @Getter
    @Setter
    @OneToMany
    private List<Pizza> pizzas;
}
