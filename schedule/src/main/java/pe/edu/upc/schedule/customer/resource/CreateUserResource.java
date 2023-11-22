package pe.edu.upc.schedule.customer.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResource {

    @NotNull(message = "firstName no debe ser nulo")
    @NotBlank(message = "firstName no debe estar vacío")
    @Size(max = 50, message = "firstName no debe exceder los 50 caracteres")
    private String firstName;

    @NotNull(message = "lastname no debe ser nulo")
    @NotBlank(message = "lastname no debe estar vacío")
    @Size(max = 50, message = "lastname no debe exceder los 50 caracteres")
    private String lastname;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthDate;

    @NotNull(message = "emailAddress no debe ser nulo")
    @NotBlank(message = "emailAddress no debe estar vacío")
    @Size(max = 50, message = "emailAddress no debe exceder los 50 caracteres")
    private String emailAddress;

    @NotNull(message = "password no debe ser nulo")
    @NotBlank(message = "password no debe estar vacío")
    @Size(max = 30, message = "password no debe exceder los 30 caracteres")
    private String password;


}
