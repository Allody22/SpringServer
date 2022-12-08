package nsu.project.controllers;




import nsu.project.models.Order;
import nsu.project.models.User;
import nsu.project.repository.UserRepository;
import nsu.project.security.services.OrderService;
import nsu.project.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/clientAndOrder")
public class ClientOrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/find-by-id")
    @PreAuthorize("hasRole('ADMIN')")
    public String getClientById(@RequestParam("id") Long id) {
        return userRepository.findById(id).toString();
    }

    /*@GetMapping("/client/get-orders")
    public String getClientOrders(@RequestParam("id") int id) {
        List<String> clientOrdersJSON = new ArrayList<>();
        User client = userRepository.findById(id);
        Set<Order> clientOrders = userRepository.getClientOrders(client);
        for (var orders : clientOrders) {
            clientOrdersJSON.add(orders.stringify());
        }
        return clientOrdersJSON.toString();
    }*/

    @GetMapping("/get-all-clients")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAllClients() {
        List<String> clients = new ArrayList<>();
        var allClients = userRepository.findAll();
        for (var oneClient : allClients) {
            clients.add(oneClient.stringify());
        }
        return clients.toString();
    }

    @PostMapping("/save-order")
    public String save(@RequestBody Order order, User user) {
        order.setTimeOfOrder();
        userService.saveOneOrder(user,order);
        return orderService.saveOrder(order).stringify();
    }

    @GetMapping("/get-all-orders")
    public String getAllOrders() {
        List<String> orders = new ArrayList<>();
        var allOrders = orderService.getAllOrders();
        for (var oneOrder : allOrders) {
            orders.add(oneOrder.stringify());
        }
        return orders.toString();
    }

}


