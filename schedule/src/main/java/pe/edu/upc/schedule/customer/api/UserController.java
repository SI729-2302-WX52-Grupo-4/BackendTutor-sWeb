package pe.edu.upc.schedule.customer.api;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.upc.schedule.customer.domain.model.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.customer.domain.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;



    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/authenticate")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        pe.edu.upc.schedule.customer.domain.model.entities.User user = userService.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            Map<String, String> response = new HashMap<>();
            response.put("id", String.valueOf(user.getId()));
            response.put("username", user.getUsername());
            response.put("password", user.getPassword());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @GetMapping("/users")
    public List<pe.edu.upc.schedule.customer.domain.model.entities.User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public pe.edu.upc.schedule.customer.domain.model.entities.User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping("/users")
    @Transactional
    public pe.edu.upc.schedule.customer.domain.model.entities.User createUser(@RequestBody pe.edu.upc.schedule.customer.domain.model.entities.User user) {
        validateUser(user);
        return userService.createUser(user);
    }
    @PutMapping("users/{id}")
    @Transactional
    public pe.edu.upc.schedule.customer.domain.model.entities.User updateUser(@PathVariable int id, @RequestBody pe.edu.upc.schedule.customer.domain.model.entities.User updatedUser) {
        validateUser(updatedUser);
        return userService.updateUser(id, updatedUser);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    // User Post Validation
    public void validateUser(pe.edu.upc.schedule.customer.domain.model.entities.User user) {
        // Validate username, password, name, lastname, email and phone

        // Username Validation
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new ValidationException("Username is required");
        }
        if (user.getUsername().length()>30) {
            throw new ValidationException("Username must not be more than 30 characters");
        }

        // Password Validation
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new ValidationException("Password is required");
        }
        if (user.getPassword().length()>30) {
            throw new ValidationException("Password must not be more than 30 characters");
        }

        // Name Validation
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ValidationException("Name is required");
        }
        if (user.getName().length()>30) {
            throw new ValidationException("Name must not be more than 30 characters");
        }

        // Lastname Validation
        if (user.getLastname() == null || user.getLastname().trim().isEmpty()) {
            throw new ValidationException("Lastname is required");
        }
        if (user.getLastname().length()>30) {
            throw new ValidationException("Lastname must not be more than 30 characters");
        }

        // Email Validation
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email is required");
        }
        if (user.getEmail().length()>50) {
            throw new ValidationException("Email must not be more than 50 characters");
        }

        // Phone Validation
        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            throw new ValidationException("Phone is required");
        }
        if (user.getPhone().length()>9) {
            throw new ValidationException("Phone must not be more than 9 characters");
        }
    }

}
