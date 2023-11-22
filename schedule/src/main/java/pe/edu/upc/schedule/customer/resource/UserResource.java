package pe.edu.upc.schedule.customer.resource;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserResource {

    private Integer id;
    private String firstName;
    private String lastname;
    private String birthDate;
    private String emailAddress;

}
