package minor.spring.pizza.controller;

import java.util.List;
import minor.spring.pizza.controller.abs.Controller;
import minor.spring.pizza.domain.Pizza;
import minor.spring.pizza.repository.PizzaMongoRepository;
import minor.spring.pizza.util.PageMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 12/15/15.
 */
@org.springframework.stereotype.Controller
public class PizzaController extends Controller<Pizza> {

    @Autowired
    private PizzaMongoRepository mongoRepository;

    @RequestMapping(PageMapping.PIZZA_MAPPING_URL)
    public String pizzaHome(final Model model) {
        init();
        List<Pizza> pizzaList = mongoRepository.findAll();
        model.addAttribute("pizzaList", pizzaList);
        return PageMapping.PIZZA_PAGE_NAME;
    }

    private void init() {
        mongoRepository.deleteAll();

        mongoRepository.save(new Pizza("Margherita", 5D));
        mongoRepository.save(new Pizza("Hawaii", 7D));
    }

}
