package minor.spring.pizza.rest.repository.abs;

import minor.spring.pizza.domain.abs.PersistentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by alex on 12/16/15.
 */
public interface RestRepository<T extends PersistentEntity> extends MongoRepository<T, String> {

}
