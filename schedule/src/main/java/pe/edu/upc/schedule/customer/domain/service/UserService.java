package pe.edu.upc.schedule.customer.domain.service;


import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.User;

import java.util.List;

@Service
public interface UserService {
    List<User> fetchAll(); //GET
  ///  User getUserById(int id);//GET
    User createUser(User user);//POST
   // User updateUser(int id, User updatedUser);//PUT
    void deleteUser(int id);//DELETE
    //User getUserByUsernameAndPassword(String username, String password);
}