package pe.edu.upc.schedule.customer.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schedule.customer.domain.model.entities.Profesor;
import pe.edu.upc.schedule.customer.domain.model.entities.VideoConference;
import pe.edu.upc.schedule.customer.domain.persistence.ProfesorRespository;
import pe.edu.upc.schedule.customer.domain.persistence.VideoConferenceRepository;
import pe.edu.upc.schedule.customer.domain.service.ProfesorService;
import pe.edu.upc.schedule.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRespository profesorRespository;
    private final Validator validator;

    //Get----------
    @Transactional(readOnly = true)
    @Override
    public List<Profesor> fetchAllProfesor() {
        return profesorRespository.findAll();
    }

    //Post-----
    @Transactional
    public Profesor createProfesor(Profesor profesor) {
        Set<ConstraintViolation<Profesor>> violations = validator.validate(profesor);
        if (violations.isEmpty()) {
            return profesorRespository.save(profesor);
        }
        String errorMessage = "Hubo problemas al crear el profesor, inténtelo de nuevo.";
        throw new ResourceValidationException("Reservation", violations + errorMessage);
    }
}
