package nsu.project.springserver.model.orders;

import nsu.project.springserver.model.clients.Client;
import nsu.project.springserver.model.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order saveOrder(Order order) {
        order.setTimeOfOrder();

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrder();
    }
}
