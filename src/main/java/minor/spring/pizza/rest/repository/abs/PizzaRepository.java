package minor.spring.pizza.rest.repository.abs;

import minor.spring.pizza.domain.Pizza;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 12/16/15.
 */
@Component
public interface PizzaRepository extends RestRepository<Pizza> {
    Pizza findByName(final String name);
}
