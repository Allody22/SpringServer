package nsu.project.springserver.model.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        Date date = new Date();
        order.setTimeOfOrder(date);
        return orderRepository.save(order);
    }
}
