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
		client.setName("Никита Ось");
		client.setEmail("n.osmushkin@g.nsu.ru");
		client.setPhone("hz");
		client.setBonuses("4 in a row");
		client.setPassword("sniks");
		clientService.save(client);
	}

	@Test
	void addOrder() {
		Order order = new Order();
		order.setTitle("Никита Ось");
		order.setComments("n.osmushkin@g.nsu.ru");
		order.setPrice(1.234);
		orderService.saveOrder(order);
	}
	//@Test
	void getAllClientsAndDelete() {
		List<Client> clients = clientService.getAllClients();
		System.out.println(clients);
		clientService.deleteAll();
	}
}
