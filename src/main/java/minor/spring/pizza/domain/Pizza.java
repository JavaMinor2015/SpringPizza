package minor.spring.pizza.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by alex on 12/15/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Pizza {

    @GraphId
    private Long graphId;

    public String name;
    public double price;
}
