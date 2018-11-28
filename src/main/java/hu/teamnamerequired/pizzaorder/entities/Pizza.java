package hu.teamnamerequired.pizzaorder.entities;

import hu.teamnamerequired.pizzaorder.enums.PizzaSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
public class Pizza {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long Id;
    @Getter
    @Setter
    String Description;
    @Getter
    @Setter
    String Name;
    @Getter
    @Setter
    String Image;
    @Getter
    @Setter
    PizzaSize Size;
    @Getter
    @Setter
    int SmallPrice;
    @Getter
    @Setter
    int MidPrice;
    @Getter
    @Setter
    int BigPrice;

}
