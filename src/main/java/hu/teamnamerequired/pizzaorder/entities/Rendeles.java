package hu.teamnamerequired.pizzaorder.entities;

import hu.teamnamerequired.pizzaorder.enums.RendelesAllapot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@NoArgsConstructor
public class Rendeles {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long Id;
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
    @ElementCollection
    Collection<Pizza> Pizzas;
    @Getter
    @Setter
    LocalDateTime OrderDate;
    @Getter
    @Setter
    String Comment;
    @Getter
    @Setter
    RendelesAllapot OrderState;

    public Rendeles(User orderedBy,String Address, Collection<Pizza> Pizzas,LocalDateTime time,String Comment,RendelesAllapot state){
        this.UserThatOrderedThePizza = orderedBy;
        if(Address.isEmpty())
            this.Address = orderedBy.getAddress();
        else
            this.Address = Address;
        this.Pizzas = Pizzas;
        this.OrderDate = time;
        this.Comment = Comment;
        this.OrderState = state;
    }
}
