package pe.edu.upc.schedule.customer.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.customer.domain.model.entities.VideoConference;
import pe.edu.upc.schedule.customer.domain.service.VideoConferenceService;
import pe.edu.upc.schedule.customer.mapping.VideoConferenceMapper;
import pe.edu.upc.schedule.customer.resource.CreateVideoConferenceResource;
import pe.edu.upc.schedule.customer.resource.VideoConferenceResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "videoconferences", description = "the videoconference API")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class VideoConferenceController {
    private final VideoConferenceService videoConferenceService;
    private final VideoConferenceMapper videoConferenceMapper;

    //Post---------------
    @PostMapping("videoconference/new")
    public ResponseEntity<VideoConferenceResource> save(@RequestBody CreateVideoConferenceResource resource){

        return ResponseEntity.ok(
                videoConferenceMapper.toResource(
                        videoConferenceService.createVideoConference(
                                videoConferenceMapper.toEntity(resource)
                        )
                )
        );
    }

    //Get------------------------
    @GetMapping("videoconference")
    public List<VideoConference> fetchAll(){
        return videoConferenceService.fetchAllConference();
    }

    //Delete-----------------
    @DeleteMapping("videoconference/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVideoConference(@PathVariable int id){
        videoConferenceService.deleteVideoConference(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    //Put--------------------
    @PutMapping("videoconference/{id}")
    public ResponseEntity<VideoConference> updateVideoConference(@PathVariable int id, @RequestBody VideoConference videoConference){
        return ResponseEntity.ok(videoConferenceService.updateVideoConference(id, videoConference));
    }
}
