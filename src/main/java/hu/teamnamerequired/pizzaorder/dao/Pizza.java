package hu.teamnamerequired.pizzaorder.dao;

import hu.teamnamerequired.pizzaorder.resources.PizzaSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
public class Pizza {
    @Id
    @Getter
    @Setter
    Long Id;
    @Getter
    @Setter
    String Description;
    @Getter
    @Setter
    PizzaSize Size;
    @Getter
    @Setter
    int Price;
}
