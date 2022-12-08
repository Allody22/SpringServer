package nsu.project.security.services;



import nsu.project.models.Order;
import nsu.project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
