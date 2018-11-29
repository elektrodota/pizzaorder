package hu.teamnamerequired.pizzaorder.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Pizza {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long Id;
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
    int SmallPrice;
    @Getter
    @Setter
    int MidPrice;
    @Getter
    @Setter
    int BigPrice;
}
