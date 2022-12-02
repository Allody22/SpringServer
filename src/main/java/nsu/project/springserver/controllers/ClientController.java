package nsu.project.springserver.controllers;

import nsu.project.springserver.model.clients.Client;
import nsu.project.springserver.model.clients.ClientService;
import nsu.project.springserver.model.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client/find-by-id")
    public String getClientById(@RequestParam("id") int id) {
        return clientService.findClientById(id).stringify();
    }

    @GetMapping("/client/get-orders")
    public String getClientOrders(@RequestParam("id") int id) {
        List<String> clientOrdersJSON = new ArrayList<>();
        Client client = clientService.findClientById(id);
        Set<Order> clientOrders = clientService.getClientOrders(client);
        for (var orders : clientOrders) {
            clientOrdersJSON.add(orders.stringify());
        }
        return clientOrdersJSON.toString();
    }

    @GetMapping("/client/get-all")
    public String getAllClients() {
        List<String> clients = new ArrayList<>();
        for (int i = 0; i < clientService.getAllClients().size(); i++) {
            clients.add(clientService.getAllClients().get(i).stringify());
        }
        return clients.toString();
    }

    @PostMapping("/client/save")
    public String save(@RequestBody Client client) {
        return clientService.save(client).stringify();
    }

    @PostMapping("/client/login")
    public ResponseEntity<?> loginUser(@RequestBody Client client) {
        List<String> userEmail = clientService.checkUserEmail(client.getEmail());
        if (userEmail.isEmpty()) {
            return new ResponseEntity<>("Почта не существует", HttpStatus.NOT_FOUND);
        }

// ВОТ ЭТО НУЖНО БУДЕТ ПЕРЕДЕЛАТЬ ЧЕРЕЗ BCrypto - хэширование пароля через спринг секьюрити
        if (!(clientService.getUserPasswordByEmail(client.getEmail())).equals(client.getPassword())) {
            return new ResponseEntity<>("Пароли не совпадают, попробуйте еще раз", HttpStatus.BAD_REQUEST);
        }

        Client client2 = clientService.getUserDetailsByEmail(client.getEmail());
        return new ResponseEntity<>(client2.stringify(), HttpStatus.OK);
    }
}


