package pe.edu.upc.schedule.customer.domain.service;


import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.User;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User createUser(User user);
    User updateUser(int id, User updatedUser);
    void deleteUser(int id);
    User getUserByUsernameAndPassword(String username, String password);
}