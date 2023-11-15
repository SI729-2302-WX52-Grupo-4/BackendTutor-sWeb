package pe.edu.upc.schedule.customer.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schedule.customer.domain.model.entities.User;
import pe.edu.upc.schedule.customer.resource.CreateUserResource;
import pe.edu.upc.schedule.customer.resource.UserResource;
import pe.edu.upc.schedule.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class UserMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public User toEntity(CreateUserResource resource) {
        return this.mapper.map(resource, User.class);
    }

    public UserResource toResource(User user) {
        return this.mapper.map(user, UserResource.class);
    }


}
