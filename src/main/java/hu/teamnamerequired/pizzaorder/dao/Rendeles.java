package hu.teamnamerequired.pizzaorder.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@NoArgsConstructor
public class Rendeles {
    @Id
    @Getter
    @Setter
    Long id;
    @Getter
    @Setter
    String email;
    @Getter
    @Setter
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
