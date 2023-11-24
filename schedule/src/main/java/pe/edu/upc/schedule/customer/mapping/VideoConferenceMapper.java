package pe.edu.upc.schedule.customer.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schedule.customer.domain.model.entities.VideoConference;
import pe.edu.upc.schedule.customer.resource.CreateVideoConferenceResource;
import pe.edu.upc.schedule.customer.resource.VideoConferenceResource;
import pe.edu.upc.schedule.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class VideoConferenceMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public VideoConference toEntity(CreateVideoConferenceResource resource) {
        return this.mapper.map(resource, VideoConference.class);
    }

    public VideoConferenceResource toResource(VideoConference videoConference) {
        return this.mapper.map(videoConference, VideoConferenceResource.class);
    }
}
