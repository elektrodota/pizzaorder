package hu.teamnamerequired.pizzaorder.dtos;

import hu.teamnamerequired.pizzaorder.entities.Pizza;
import hu.teamnamerequired.pizzaorder.enums.PizzaSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PizzaDto {

    @Getter
    @Setter
    private Long pizzaID;
    @Getter
    @Setter
    private String pizzaName;
    @Getter
    @Setter
    private String pizzaImage;
    public PizzaDto(Pizza pizza){
        pizzaID=pizza.getId();
        pizzaName=pizza.getName();
        pizzaImage=pizza.getImage();
    }
}
