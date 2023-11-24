package pe.edu.upc.schedule.customer.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.schedule.customer.domain.model.entities.Profesor;
import pe.edu.upc.schedule.customer.resource.CreateProfesorResource;
import pe.edu.upc.schedule.customer.resource.ProfesorResource;
import pe.edu.upc.schedule.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class ProfesorMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;
    public Profesor toEntity(CreateProfesorResource resource){
        return  this.mapper.map(resource, Profesor.class);
    }

    public ProfesorResource toResource(Profesor profesor){
        return this.mapper.map(profesor, ProfesorResource.class);
    }
}
