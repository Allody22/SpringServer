package nsu.project.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  private String phone;
  @NotBlank
  @Size(max = 120)
  private String password;

  @OneToMany(orphanRemoval =true, mappedBy = "client")
  private Set<Order> orders = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email,String phone, String password) {
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }

  public String stringify() {
    List<Integer> ordersId = new ArrayList<>();
    for (var x :orders){
      ordersId.add(x.getId());
    }
    return "{" +
            "\"id\":" + id +
            ", \"name\":\"" + username + '\"' +
            ", \"email\":\"" + email + '\"' +
            ", \"phone\":\"" + phone + '\"' +
            ", \"password\":\"" + password + '\"' +
            ", \"orders\":" + ordersId +
            '}';
  }

  public Set<Order> getOrders() {
    return orders;
  }

  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public boolean addOneOrder(Order order) {
    return this.orders.add(order);
  }
}
