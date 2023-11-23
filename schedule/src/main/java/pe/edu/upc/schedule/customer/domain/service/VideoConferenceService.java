package pe.edu.upc.schedule.customer.domain.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.schedule.customer.domain.model.entities.User;
import pe.edu.upc.schedule.customer.domain.model.entities.VideoConference;

import java.util.List;

@Service
public interface VideoConferenceService {

    //Get
    List<VideoConference> fetchAllConference();

    //Post
    VideoConference createVideoConference(VideoConference videoConference);

    //Put
    VideoConference updateVideoConference(int id, VideoConference updatedVideoConference);//PUT

    //Delete
    void deleteVideoConference(int id);
}
