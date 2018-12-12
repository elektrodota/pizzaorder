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
    @Getter
    @Setter
    int Price;
    @Getter
    @Setter
    PizzaSize pizzaSize;
    public PizzaDto(Pizza pizza,int price,PizzaSize size){
        pizzaID=pizza.getId();
        pizzaName=pizza.getName();
        pizzaImage=pizza.getImage();
        Price=price;
        pizzaSize=size;
    }
}
