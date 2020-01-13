package com.yyfolium.springbootrestserver.auth;

import com.yyfolium.springbootrestserver.session.SessionCheck;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionRepository sessionRepository;

    @Value("${server.servlet.session.timeout}")
    private int sessionExpiredTime;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        String loginResult = null;

        if(userService.authentication(user.getId(), user.getPassword())) {
            Session session = sessionRepository.createSession();
            session.setAttribute("uuid", userService.getOneById(user.getId()).get().getUuid());
            sessionRepository.save(session);
            
            loginResult = session.getId();
        }

        return loginResult;
    }

    @PostMapping("/welcome-user")
    public String welcomeUser() {
        Session session = sessionRepository.createSession();
        session.setAttribute("uuid", userService.getOneById("yong").get().getUuid());
        sessionRepository.save(session);
        return session.getId();
    }

    @PostMapping("/session-validation")
    public boolean sessionValidation(@RequestBody Map requestObject) {

        System.out.println("===============================");
        System.out.println(requestObject.toString());
        System.out.println("===============================");

        Session session = sessionRepository.findById((String) requestObject.get("sessionId"));

        if(session==null)
            return false;

        return !session.isExpired();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map requestObject) {
        sessionRepository.deleteById((String) requestObject.get("sessionId"));
        return ResponseEntity.ok().build();
    }
}
