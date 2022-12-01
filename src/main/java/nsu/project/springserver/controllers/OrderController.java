package nsu.project.springserver.controllers;


import nsu.project.springserver.model.clients.Client;
import nsu.project.springserver.model.orders.Order;
import nsu.project.springserver.model.orders.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/order/save")
    public Order save(@RequestBody Order order) {
        Date date = new Date();
        order.setTimeOfOrder(date);
        return orderRepository.save(order);
    }
}
