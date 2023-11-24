package pe.edu.upc.schedule.customer.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorResource {

    private Integer id;
    private String name;
    private String rating;
    private String course;
    private String description;
    private String image;

}
