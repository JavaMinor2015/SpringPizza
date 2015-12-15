package minor.spring.pizza.controller;

import java.util.*;
import minor.spring.pizza.controller.abs.Controller;
import minor.spring.pizza.domain.Customer;
import minor.spring.pizza.domain.Pizza;
import minor.spring.pizza.repository.CustomerNeoRepository;
import minor.spring.pizza.util.PageMapping;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 12/15/15.
 */
@org.springframework.stereotype.Controller
public class PizzaController extends Controller<Pizza> {

//    @Autowired
//    private PizzaMongoRepository mongoRepository;

    @Autowired
    private CustomerNeoRepository customerNeoRepository;

    @Autowired
    private GraphDatabase graphDatabase;
//
//    @RequestMapping(PageMapping.PIZZA_MAPPING_URL)
//    public String pizzaHome(final Model model) {
//        init();
//        List<Pizza> pizzaList = mongoRepository.findAll();
//        model.addAttribute("pizzaList", pizzaList);
//        return PageMapping.PIZZA_PAGE_NAME;
//    }

    @RequestMapping(PageMapping.PIZZA_MAPPING_URL + "c")
    public String getCustomers(final Model model) {
        initCustomers();
        List<Customer> customerList = new ArrayList<>();
        Transaction tx = graphDatabase.beginTx();
        for (final Customer customer : customerNeoRepository.findByPizzasName("Margherita")) {
            customerList.add(customer);
        }
        tx.success();
        model.addAttribute("customers", customerList);
        return PageMapping.PIZZA_PAGE_NAME + "c";
    }

    private void initCustomers() {
        Transaction tx = graphDatabase.beginTx();
        Set<Pizza> pizzaSet = new HashSet<>();
        pizzaSet.add(new Pizza(null, "Margherita", 5D));
        pizzaSet.add(new Pizza(null, "Margherita", 5D));
        Customer me = new Customer("Me");

        Customer notMe = new Customer("Not Me");
        notMe.setPizzas(new HashSet<Pizza>());
        notMe.getPizzas().add(new Pizza(null, "Hawaii", 7D));

        me.setPizzas(pizzaSet);
        try {
            customerNeoRepository.save(me);
            customerNeoRepository.save(notMe);

            me = customerNeoRepository.findByName(me.getName());
            me.getPizzas().add(new Pizza(null, "Hawaii", 7D));
            customerNeoRepository.save(me);

            tx.success();
        } finally {
            tx.close();
        }
    }

//    private void init() {
//        mongoRepository.deleteAll();
//
//        mongoRepository.save(new Pizza(1L, "Margherita", 5D));
//        mongoRepository.save(new Pizza(2L, "Hawaii", 7D));
//    }

}
