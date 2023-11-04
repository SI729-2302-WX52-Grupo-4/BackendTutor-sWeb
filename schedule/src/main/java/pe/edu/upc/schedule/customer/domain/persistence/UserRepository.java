package pe.edu.upc.schedule.customer.domain.persistence;

import pe.edu.upc.schedule.customer.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByUsernameAndPassword(String username, String password);
}
