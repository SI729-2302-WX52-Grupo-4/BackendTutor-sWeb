package pe.edu.upc.schedule.customer.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.upc.schedule.customer.domain.model.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.schedule.customer.domain.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import pe.edu.upc.schedule.customer.mapping.UserMapper;
import pe.edu.upc.schedule.customer.resource.CreateUserLoginResource;
import pe.edu.upc.schedule.customer.resource.CreateUserResource;
import pe.edu.upc.schedule.customer.resource.UserLoginResource;
import pe.edu.upc.schedule.customer.resource.UserResource;
import pe.edu.upc.schedule.shared.exception.FetchNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Tag(name = "users", description = "the user API")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    //POST-----------
    @Operation(
            summary = "Add a new user " ,
            description = "Add a new user",
            operationId = "addUser",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @PostMapping("new")
    public ResponseEntity<UserResource> save(@RequestBody CreateUserResource resource){
        return new ResponseEntity<>(
                userMapper.toResource(userService.createUser(userMapper.toEntity(resource))),
                HttpStatus.CREATED);
    }

    //GET------------
    @Operation(
            summary = "Get user details by ID",
            description = "Retrieve user details by providing the user ID",
            operationId = "getUserById",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserResource.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.fetchAll();
    }

    //DELETE----------
    @Operation(
            summary = "Delete user by ID",
            description = "Delete user details by providing the user ID",
            operationId = "deleteUserById",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "User deleted successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //POST Authentication------------
    @Operation(
            summary = "User authentication",
            description = "Authenticate a user by providing email and password",
            operationId = "authenticateUser",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful authentication",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserLoginResource .class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized: User not registered or invalid credentials",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )

            }
    )
    @PostMapping("login")
    public ResponseEntity<UserResource> login(@RequestBody CreateUserLoginResource resource) {
        String email = resource.getEmailAddress();
        String password = resource.getPassword();

        User user = userService.findMyCredential(email, password);

        if (user != null) {
            return new ResponseEntity<>(
                    userMapper.toResource(user),
                    HttpStatus.CREATED);
        } else {
            throw new FetchNotFoundException("User", "emailAddress", email);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Integer id) {
        User user = userService.getUserByIdWithDetails(id);
        return new ResponseEntity<>(
                userMapper.toResource(user),
                HttpStatus.OK);
    }
}