package pe.edu.upc.schedule.customer.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateProfesorResource {
    @NotNull(message = "name no debe ser nulo")
    @NotBlank(message = "name no debe de estar vacio")
    @Size(max = 50, message = "name no debe de exceder los 50 caracteres")
    private String name;

    @NotNull(message = "rating no debe ser nulo")
    @NotBlank(message = "rating no debe de estar vacio")
    @Size(max = 50, message = "rating no debe de exceder los 50 caracteres")
    private String rating;

    @NotNull(message = "course no debe ser nulo")
    @NotBlank(message = "course no debe de estar vacio")
    @Size(max = 50, message = "course no debe de exceder los 50 caracteres")
    private String course;

    @NotNull(message = "description no debe ser nulo")
    @NotBlank(message = "description no debe de estar vacio")
    @Size(max = 500, message = "description no debe de exceder los 500 caracteres")
    private String description;

    @NotNull(message = "image no debe ser nulo")
    @NotBlank(message = "image no debe de estar vacio")
    @Size(max = 500, message = "image no debe de exceder los 500 caracteres")
    private String image;
}
