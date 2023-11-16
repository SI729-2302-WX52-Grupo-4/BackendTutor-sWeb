package pe.edu.upc.schedule.customer.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserLoginResource {

    @NotNull(message = "emailAddress no debe ser nulo")
    @NotBlank(message = "emailAddress no debe estar vacío")
    @Size(max = 50, message = "emailAddress no debe exceder los 50 caracteres")
    private String emailAddress;

    @NotNull(message = "password no debe ser nulo")
    @NotBlank(message = "password no debe estar vacío")
    @Size(max = 30, message = "password no debe exceder los 30 caracteres")
    private String password;
}
