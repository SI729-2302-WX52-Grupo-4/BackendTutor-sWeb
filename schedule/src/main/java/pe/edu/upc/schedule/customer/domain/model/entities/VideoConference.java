package pe.edu.upc.schedule.customer.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="video_conferences")
public class VideoConference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Nombre de la sala
    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(name = "room_name", nullable = false, length = 30)
    private String RoomName;

    // Nombre del creador de la session
    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(name = "creator_name", nullable = false, length = 30)
    private String CreatorName;

    //fecha de inicio de la sesion
    @DateTimeFormat(pattern = "yyyy-MM-dd") //año - mes- día
    @Column(name = "video_conference_date")
    private LocalDate VideoConferenceDate;

    //Hora de cuando se iniciará la session de la session
    @DateTimeFormat(pattern = "HH:mm") //Hora - minutos - segundos
    @Column(name = "video_conference_time")
    private LocalTime VideoConferenceTime;

    //Fecha y hora de la creation de la session (esto no se verá en el front)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "creation_conference_date")
    private LocalDateTime CreationConferenceDate;

    //-------------------------------------


}
