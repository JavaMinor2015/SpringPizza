package minor.spring.pizza.rest.controller;

import javax.annotation.PostConstruct;
import minor.spring.pizza.domain.Pizza;
import minor.spring.pizza.rest.abs.RestController;
import minor.spring.pizza.rest.repository.abs.PizzaRepository;
import minor.spring.pizza.util.PageMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by alex on 12/16/15.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping(PageMapping.PIZZA_REST_URL)
public class PizzaRestController extends RestController<Pizza> {


    @Autowired
    private PizzaRepository pizzaRepository;

    @PostConstruct
    public void init() {
        setRestRepository(pizzaRepository);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public Pizza getByName(@RequestParam(value = "name", defaultValue = "") final String name) {
        return pizzaRepository.findByName(name);
    }

    @Override
    public String getBaseUrl() {
        return PageMapping.PIZZA_REST_URL;
    }
}
