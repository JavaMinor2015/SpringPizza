package minor.spring.pizza.domain;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Created by alex on 12/15/15.
 */
@Data
@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @GraphId
    private Long id;

    private String name;

    @RelatedTo(type = "PIZZA", direction = Direction.BOTH)
    public @Fetch Set<Pizza> pizzas;

    public Customer(final String name) {
        this.name = name;
    }
}
