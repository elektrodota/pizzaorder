package hu.teamnamerequired.pizzaorder.dao;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
