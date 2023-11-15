package pe.edu.upc.schedule.customer.resource;

import lombok.*;

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
