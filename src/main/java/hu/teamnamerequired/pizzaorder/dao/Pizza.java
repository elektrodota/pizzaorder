package hu.teamnamerequired.pizzaorder.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

public class Pizza {
    @Id
    @Getter
    @Setter
    Long id;
    @Getter
    @Setter
    String leiras;
    @Getter
    @Setter
    int kisAr;
    @Getter
    @Setter
    int kozepesAr;
    @Getter
    @Setter
    int nagyAr;
}
