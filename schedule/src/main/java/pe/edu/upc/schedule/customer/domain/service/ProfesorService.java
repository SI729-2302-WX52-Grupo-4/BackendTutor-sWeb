package pe.edu.upc.schedule.customer.domain.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.Profesor;

import java.util.List;

@Service
public interface ProfesorService {

    //GET
    List<Profesor> fetchAllProfesor();
   // POST
   Profesor createProfesor(Profesor profesor);
}
