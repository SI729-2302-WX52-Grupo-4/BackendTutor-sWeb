package pe.edu.upc.schedule.customer.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.customer.domain.model.entities.Profesor;
import pe.edu.upc.schedule.customer.domain.model.entities.VideoConference;
import pe.edu.upc.schedule.customer.domain.service.ProfesorService;
import pe.edu.upc.schedule.customer.mapping.ProfesorMapper;
import pe.edu.upc.schedule.customer.resource.CreateProfesorResource;
import pe.edu.upc.schedule.customer.resource.ProfesorResource;

import java.util.List;

@Tag(name="Profesores", description = "The profesores API")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProfesorController {
    private final ProfesorService profesorService;
    private final ProfesorMapper profesorMapper;

    //Post
    @PostMapping("/profesor/new")
    public ResponseEntity<ProfesorResource> save(@RequestBody CreateProfesorResource profesorResource){

        return  ResponseEntity.ok(
          profesorMapper.toResource(
                profesorService.createProfesor(
                        profesorMapper.toEntity(profesorResource)
                )
          )
        );
    }

    //Get------------------------
    @GetMapping("/profesores")
    public List<Profesor> fetchAll(){
        return profesorService.fetchAllProfesor();
    }
}
