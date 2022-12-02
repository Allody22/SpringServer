package nsu.project.springserver.controllers;


import nsu.project.springserver.model.clients.Client;
import nsu.project.springserver.model.clients.ClientService;
import nsu.project.springserver.model.orders.Order;
import nsu.project.springserver.model.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/order/save")
    public String save(@RequestBody Order order, Client client) {
        order.setTimeOfOrder();
        clientService.saveOneOrder(client,order);
        return orderService.saveOrder(order).stringify();
    }

    @GetMapping("/order/get-all")
    public String getAllOrders() {
        List<String> orders = new ArrayList<>();
        for (int i = 0; i < orderService.getAllOrders().size(); i++) {
            orders.add(orderService.getAllOrders().get(i).stringify());
        }
        return orders.toString();
    }


}
