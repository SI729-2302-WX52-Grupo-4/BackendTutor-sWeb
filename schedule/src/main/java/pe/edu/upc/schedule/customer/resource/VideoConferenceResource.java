package pe.edu.upc.schedule.customer.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class VideoConferenceResource {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("RoomName")
    private String RoomName;
    @JsonProperty("CreatorName")
    private String CreatorName;
    @JsonProperty("VideoConferenceDate")
    private LocalDate VideoConferenceDate;
    @JsonProperty("VideoConferenceTime")
    private LocalTime VideoConferenceTime;
    @JsonProperty("CreationConferenceDate")
    private LocalDateTime CreationConferenceDate;


}
