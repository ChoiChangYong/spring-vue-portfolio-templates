package com.yyfolium.springbootrestserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{uuid}")
    public Optional<User> getUserByUuid(@PathVariable(value = "uuid") String uuid) {
        return userService.getOneByUuid(uuid);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/users/{uuid}")
    public User updateUser(@PathVariable(value = "uuid") String uuid,
                           @Valid @RequestBody User user,
                           @RequestParam("profileImage") MultipartFile multipartFile) throws IOException {
        return userService.update(uuid, user, multipartFile);
    }

    @DeleteMapping("/users/{uuid}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "uuid") String uuid) {
        userService.deleteByUuid(uuid);
        return ResponseEntity.ok().build();
    }
}
