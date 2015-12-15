package minor.spring.pizza.domain;

import lombok.Data;

/**
 * Created by alex on 12/15/15.
 */
@Data
public class PizzaOrderItem {
    private Pizza pizza;
    private int amount;
}
