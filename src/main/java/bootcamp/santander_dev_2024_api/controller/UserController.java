package bootcamp.santander_dev_2024_api.controller;

import bootcamp.santander_dev_2024_api.model.User;
import bootcamp.santander_dev_2024_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreated){
        var userCreated = userService.create(userToCreated);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
