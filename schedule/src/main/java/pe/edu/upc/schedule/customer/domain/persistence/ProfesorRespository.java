package pe.edu.upc.schedule.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.customer.domain.model.entities.Profesor;

@Repository
public interface ProfesorRespository extends JpaRepository<Profesor, Integer> {

}
