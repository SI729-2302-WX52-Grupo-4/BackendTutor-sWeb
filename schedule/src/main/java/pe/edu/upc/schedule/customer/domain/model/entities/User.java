package pe.edu.upc.schedule.customer.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.transform.Source;
import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //nombre de usuario
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    //apellido de usuario
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;

    // fecha de nacimiento del usuario
    @DateTimeFormat(pattern = "yyyy-MM-dd") //numero "fecha"
    @Column(name = "birth_date")
    private String birthDate;

    //correo del usuario
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "email_address", nullable = false, length = 50)
    private String emailAddress;

    //contraseña del usuario
    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(name = "password", nullable = false, length = 30)
    private String password;

}