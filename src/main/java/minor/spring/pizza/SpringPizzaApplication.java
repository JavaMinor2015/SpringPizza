package minor.spring.pizza;

import java.io.File;
import java.io.IOException;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.io.fs.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@SpringBootApplication
public class SpringPizzaApplication {
    @Configuration
    @EnableNeo4jRepositories(basePackages = "minor.spring.pizza")
    static class ApplicationConfig extends Neo4jConfiguration {

        public ApplicationConfig() {
            setBasePackage("minor.spring.pizza");
        }

        @Bean
        GraphDatabaseService graphDatabaseService() {
            return new GraphDatabaseFactory().newEmbeddedDatabase("pizza.db");
        }
    }

    public static void main(String[] args) throws IOException {
        FileUtils.deleteRecursively(new File("pizza.db"));
        SpringApplication.run(SpringPizzaApplication.class, args);
    }
}
