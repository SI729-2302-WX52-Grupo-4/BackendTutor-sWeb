package pe.edu.upc.schedule.customer.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schedule.customer.domain.model.entities.User;
import pe.edu.upc.schedule.customer.domain.model.entities.VideoConference;
import pe.edu.upc.schedule.customer.domain.persistence.VideoConferenceRepository;
import pe.edu.upc.schedule.customer.domain.service.UserService;
import pe.edu.upc.schedule.customer.domain.service.VideoConferenceService;
import pe.edu.upc.schedule.shared.exception.ResourceValidationException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class VideoConferenceServiceImpl implements VideoConferenceService {

    private final VideoConferenceRepository videoconferenceRepositoryRepository;
    private final Validator validator;

    //Get----------
    @Transactional(readOnly = true)
    @Override
    public List<VideoConference> fetchAllConference() {
        return videoconferenceRepositoryRepository.findAll();
    }

    //Post-----
    @Transactional
    @Override
    public VideoConference createVideoConference(VideoConference videoConference) {
        Set<ConstraintViolation<VideoConference>> violations = validator.validate(videoConference);
        if (violations.isEmpty()) {
            videoConference.setCreationConferenceDate(videoConference.getVideoConferenceDate()+" " + videoConference.getVideoConferenceTime());
            return videoconferenceRepositoryRepository.save(videoConference);
        }
        String errorMessage = "Hubo problemas al crear la sesión, inténtelo de nuevo.";
        throw new ResourceValidationException("Reservation", violations + errorMessage);
    }

    //Put-----------
    @Transactional
    @Override
    public VideoConference updateVideoConference(int id, VideoConference updatedVideoConference) {
        // Buscar la videoconferencia existente por ID
        VideoConference existingVideoConference = videoconferenceRepositoryRepository.findById(id)
                .orElseThrow(() -> new ResourceValidationException("VideoConference", "No se encontró la videoconferencia con el ID: " + id));

        // Aplicar los cambios proporcionados en updatedVideoConference a existingVideoConference
        existingVideoConference.setRoomName(updatedVideoConference.getRoomName());
        existingVideoConference.setVideoConferenceDate(updatedVideoConference.getVideoConferenceDate());
        existingVideoConference.setVideoConferenceTime(updatedVideoConference.getVideoConferenceTime());
        // Agregar otros campos según sea necesario

        // Validar la videoconferencia actualizada
        Set<ConstraintViolation<VideoConference>> violations = validator.validate(existingVideoConference);
        if (violations.isEmpty()) {
            // Guardar la videoconferencia actualizada en la base de datos
            return videoconferenceRepositoryRepository.save(existingVideoConference);
        } else {
            throw new ResourceValidationException("VideoConference", violations);
        }
    }

    //Delete-------
    @Transactional
    @Override
    public void deleteVideoConference(int id) {
        videoconferenceRepositoryRepository.deleteById(id);
    }
}
