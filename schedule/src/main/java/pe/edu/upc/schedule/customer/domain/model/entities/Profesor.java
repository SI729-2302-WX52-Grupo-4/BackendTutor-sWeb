package pe.edu.upc.schedule.customer.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //nombre de profesor
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    //calificacion del profesor
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "rating", nullable = false, length = 50)
    private String rating;

    //curso de profesor
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "course", nullable = false, length = 50)
    private String course;

    //descripcion de profesor
    @NotNull
    @NotBlank
    @Size(max = 500)
    @Column(name = "description", nullable = false, length = 500)
    private String description;

    //imagen de profesor
    @NotNull
    @NotBlank
    @Size(max = 500)
    @Column(name = "image", nullable = false, length = 500)
    private String image;

    //nombre de profesor
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "clase", nullable = false, length = 50)
    private String clase;
}
