package hu.teamnamerequired.pizzaorder.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Role {
    @Id
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String roleName;

}
