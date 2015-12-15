package minor.spring.pizza.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 * Created by alex on 12/15/15.
 */
@Data
public class PizzaOrder {
    private LocalDateTime orderDate;
    private List<PizzaOrderItem> orderItemList;
}
