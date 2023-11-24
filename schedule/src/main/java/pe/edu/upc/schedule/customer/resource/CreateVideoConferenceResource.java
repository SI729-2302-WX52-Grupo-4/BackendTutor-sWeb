package pe.edu.upc.schedule.customer.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateVideoConferenceResource {

    // lo que pondré en el post
    @NotNull(message = "RoomName no debe ser nulo")
    @NotBlank(message = "RoomName no debe estar vacío")
    @Size(max = 30, message = "RoomName no debe exceder los 30 caracteres")
    private String RoomName;

    @NotNull(message = "CreatorName no debe ser nulo")
    @NotBlank(message = "CreatorName no debe estar vacío")
    @Size(max = 50, message = "CreatorName no debe exceder los 50 caracteres")
    private String CreatorName;

    @DateTimeFormat(pattern = "yyyy-MM-dd") //año - mes- día
    private String VideoConferenceDate;

    @DateTimeFormat(pattern = "HH:mm") //Hora - minutos - segundos
    private String VideoConferenceTime;

}
