package nsu.project.springserver.model.clients;

import jakarta.persistence.*;
import nsu.project.springserver.model.orders.Order;


import java.util.*;

/** Client entity with postgreSQL table.
 * It has id, name, phone, email, password and bonuses fields
 *
 */
@Entity()
@Table(name = "clients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "phone")
        })
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    private String bonuses;
    private String password;
    @OneToMany(orphanRemoval =true, mappedBy = "client")
    private Set<Order> orders = new HashSet<>();


    public String stringify() {
        List<Integer> ordersId = new ArrayList<>();
        for (var x :orders){
            ordersId.add(x.getId());
        }
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"email\":\"" + email + '\"' +
                ", \"phone\":\"" + phone + '\"' +
                ", \"bonuses\":\"" + bonuses + '\"' +
                ", \"password\":\"" + password + '\"' +
                ", \"orders\":" + ordersId +
                '}';
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public boolean addOneOrder(Order order) {
        return this.orders.add(order);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBonuses() {
        return bonuses;
    }

    public void setBonuses(String bonuses) {
        this.bonuses = bonuses;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}