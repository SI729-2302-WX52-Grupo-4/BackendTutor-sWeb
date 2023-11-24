package pe.edu.upc.schedule.customer.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.schedule.customer.domain.model.entities.VideoConference;

@Repository
public interface VideoConferenceRepository extends JpaRepository<VideoConference, Integer> {

}
