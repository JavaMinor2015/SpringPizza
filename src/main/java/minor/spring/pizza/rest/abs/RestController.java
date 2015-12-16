package minor.spring.pizza.rest.abs;

import lombok.Setter;
import minor.spring.pizza.domain.abs.PersistentEntity;
import minor.spring.pizza.rest.repository.abs.RestRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 12/16/15.
 */
@org.springframework.web.bind.annotation.RestController
public abstract class RestController<T extends PersistentEntity> {

    @Setter
    private RestRepository<T> restRepository;

    public abstract String getBaseUrl();

    @RequestMapping("/{id}")
    public T getById(@PathVariable("id") final String id) {
        return restRepository.findOne(id);
    }

}
