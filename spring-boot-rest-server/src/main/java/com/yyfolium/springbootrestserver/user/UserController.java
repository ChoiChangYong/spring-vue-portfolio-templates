package com.yyfolium.springbootrestserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{uuid}")
    public User getUserById(@PathVariable(value = "uuid") String userUuid) {
        return userService.findByUuid(userUuid);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/users/{uuid}")
    public User updateUser(@PathVariable(value = "uuid") String userUuid,
                           @Valid @RequestBody User userDetails) {
        return userService.update(userUuid, userDetails);
    }

    @DeleteMapping("/users/{uuid}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "uuid") String userUuid) {
        userService.deleteByUuid(userUuid);
        return ResponseEntity.ok().build();
    }
}
