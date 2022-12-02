package nsu.project.springserver;


import nsu.project.springserver.model.clients.Client;
import nsu.project.springserver.model.clients.ClientService;
import nsu.project.springserver.model.orders.Order;
import nsu.project.springserver.model.orders.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private ClientService clientService;
	@Autowired
	private OrderService orderService;
	@Test
	void addClientTest() {
		Client client = new Client();
		client.setName("two");
		client.setEmail("two");
		client.setPhone("two");
		client.setBonuses("two");
		client.setPassword("twotwo");
		clientService.save(client);
	}

	@Test
	void addOrder() {
		Order order = new Order();
		order.setTitle("Заказ 2");
		order.setComments("2222");
		order.setPrice(2.345);
		orderService.saveOrder(order);
	}
	//@Test
	void getAllClientsAndDelete() {
		List<Client> clients = clientService.getAllClients();
		System.out.println(clients);
		clientService.deleteAll();
	}
}
