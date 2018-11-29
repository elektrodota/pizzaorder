package hu.teamnamerequired.pizzaorder.entities;

import hu.teamnamerequired.pizzaorder.dtos.PizzaDto;
import hu.teamnamerequired.pizzaorder.enums.PizzaSize;
import hu.teamnamerequired.pizzaorder.enums.RendelesAllapot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
public class Rendeles {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name="user_email")
    User UserThatOrderedThePizza;
    @Getter
    @Setter
    private String Address;
    @Getter
    @Setter
    @OneToMany
    private Map<PizzaSize,PizzaGroup> pizzas;
    @Getter
    @Setter
    LocalDateTime OrderDate;
    @Getter
    @Setter
    String Comment;
    @Getter
    @Setter
    RendelesAllapot OrderState;

    public Rendeles(User orderedBy,String Address, Map<PizzaSize,PizzaGroup> Pizzas,LocalDateTime time,String Comment,RendelesAllapot state){
        this.UserThatOrderedThePizza = orderedBy;
        if(Address.isEmpty())
            this.Address = orderedBy.getAddress();
        else
            this.Address = Address;
        this.pizzas = Pizzas;
        this.OrderDate = time;
        this.Comment = Comment;
        this.OrderState = state;
    }
}
