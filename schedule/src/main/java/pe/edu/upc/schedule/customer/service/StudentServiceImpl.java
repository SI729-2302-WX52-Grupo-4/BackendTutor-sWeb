package pe.edu.upc.schedule.customer.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schedule.customer.domain.model.entities.User;
import pe.edu.upc.schedule.customer.domain.persistence.UserRepository;
import pe.edu.upc.schedule.customer.domain.service.UserService;
import pe.edu.upc.schedule.shared.exception.ResourceValidationException;


import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    //GET
    @Transactional(readOnly = true)
    @Override
    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    //SET
    @Transactional
    @Override
    //SET
    public User createUser(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(violations.isEmpty()) {
            return userRepository.save(user);
        }
        throw new ResourceValidationException("Reservation", violations);
    }

    //DELETE
    @Transactional
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
