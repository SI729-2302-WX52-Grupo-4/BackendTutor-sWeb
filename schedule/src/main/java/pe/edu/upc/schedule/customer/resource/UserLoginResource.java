package pe.edu.upc.schedule.customer.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResource {
    private Integer id;
    private String firstName;
    private String lastname;
    private String emailAddress;
}
