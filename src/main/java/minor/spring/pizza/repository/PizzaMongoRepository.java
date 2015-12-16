package minor.spring.pizza.repository;

import minor.spring.pizza.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 12/15/15.
 */
@Component
public interface PizzaMongoRepository extends MongoRepository<Pizza, String> {
    Pizza findByName(final String name);
}
