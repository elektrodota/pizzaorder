package hu.teamnamerequired.pizzaorder.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;

public class Rendeles {
    @Id
    @Getter
    @Setter
    Long id;
    @Getter
    @Setter
    @OneToOne
    String email;
    @Getter
    @Setter
    @OneToMany
    Long pizzaId;
    @Getter
    @Setter
    int meret;
    @Getter
    @Setter
    LocalDate datum;
    String megjegyzes;
    @Getter
    @Setter
    int ar;
    @Getter
    @Setter
    boolean allapot;
}
