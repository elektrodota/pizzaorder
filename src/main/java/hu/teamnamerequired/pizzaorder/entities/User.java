package hu.teamnamerequired.pizzaorder.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@NoArgsConstructor
public class User {
    @Id
    @Getter
    @Setter
    private String Email;
    @Getter
    @Setter
    private String Password;
    @Getter
    @Setter
    private String Address;
    @Getter
    @Setter
    @ElementCollection
    private Collection<Pizza> shoppingCart;
}
