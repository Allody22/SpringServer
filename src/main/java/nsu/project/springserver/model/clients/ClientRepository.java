package nsu.project.springserver.model.clients;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    @Query(value = "SELECT email FROM clients WHERE email = :email ", nativeQuery = true)
    List<String> checkUserEmail(@Param("email") String email);

    @Query(value = "SELECT password FROM clients WHERE email = :email", nativeQuery = true)
    String getUserPasswordByEmail(@Param("email") String email);

    @Query(value = " SELECT * FROM clients WHERE email = :email", nativeQuery = true)
    Client GetUserDetailsByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM clients WHERE id =:id", nativeQuery = true)
    Client findByIdClient(@Param("id") Integer id);


    //@Query(value = "SELECT * FROM clients RIGHT JOIN orders ON clients.id = orders.client_id ", nativeQuery = true)

}
