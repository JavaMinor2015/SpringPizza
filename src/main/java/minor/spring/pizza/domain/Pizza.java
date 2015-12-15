package minor.spring.pizza.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import minor.spring.pizza.domain.abs.PersistentEntity;

/**
 * Created by alex on 12/15/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza extends PersistentEntity {
    public String name;
    public double price;
}
