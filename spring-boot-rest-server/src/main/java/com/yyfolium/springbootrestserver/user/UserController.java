package com.yyfolium.springbootrestserver.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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

    @GetMapping("/user")
    public User getUserBySessionId(@RequestParam Map requestObject) {
        return userService.getBySessionId(requestObject.get("sessionId").toString());
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }





    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody Map requestObject) {

        Map sessionObject = (Map) requestObject.get("sessionObject");
        System.out.println(sessionObject.toString());
        System.out.println(sessionObject.get("sessionId").toString());
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.convertValue(requestObject.get("user"), User.class);

        return userService.update(sessionId, user);
    }

    @PostMapping("/users/image-upload")
    public ResponseEntity<?> profileImageUpload(@RequestParam Map requestObject, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println(requestObject.toString());

        String sessionId = requestObject.get("sessionId").toString();
        userService.profileImageUpload(sessionId, multipartFile);
        return ResponseEntity.ok().build();
    }





    @DeleteMapping("/users/{uuid}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "uuid") String uuid) {
        userService.deleteByUuid(uuid);
        return ResponseEntity.ok().build();
    }
}
