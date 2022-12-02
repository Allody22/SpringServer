package nsu.project.springserver.model.orders;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    List<Order> getAllOrder();


}
