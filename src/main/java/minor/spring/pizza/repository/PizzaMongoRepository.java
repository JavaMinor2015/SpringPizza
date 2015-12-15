package minor.spring.pizza.repository;

import minor.spring.pizza.domain.Pizza;

/**
 * Created by alex on 12/15/15.
 */
public interface PizzaMongoRepository { //extends MongoRepository<Pizza, String> {
    Pizza findByName(final String name);
}
