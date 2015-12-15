package minor.spring.pizza.domain.abs;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by alex on 12/15/15.
 */
@Data
public abstract class PersistentEntity {

    @Id
    private String id;
}
