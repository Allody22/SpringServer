package nsu.project.springserver.model.orders;


import jakarta.persistence.*;
import nsu.project.springserver.model.clients.Client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Date timeOfOrder;
    private Double price;
    private String comments;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    public String stringify() {
        return "{" +
                "\"id\":" + id +
                ", \"title\":\"" + title + '\"' +
                ", \"timeOfOrder\":\"" + timeOfOrder + '\"' +
                ", \"price\":" + price +
                ", \"comments\":\"" + comments + '\"' +
                ", \"client_id\":" + client.getId() +
                '}';
    }

    public Client getClient_id() {
        return client;
    }

    public void setClient_id(Client client_id) {
        this.client = client_id;
    }

    public int getId() {
        return id;
    }

    public Date getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder() {
        this.timeOfOrder = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
