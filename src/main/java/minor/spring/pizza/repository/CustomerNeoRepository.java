package minor.spring.pizza.repository;

import minor.spring.pizza.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alex on 12/15/15.
 */
public interface CustomerNeoRepository extends CrudRepository<Customer, String> {
    Iterable<Customer> findByPizzasName(final String pizzaName);

    Customer findByName(final String name);
}
