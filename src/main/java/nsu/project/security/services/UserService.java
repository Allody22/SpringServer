package nsu.project.security.services;

import nsu.project.models.Order;
import nsu.project.models.User;
import nsu.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public boolean saveOneOrder(User User, Order order) {
        return User.addOneOrder(order);
    }
}