package com.yyfolium.springbootrestserver.auth;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        String result = "0";

        if(userService.authentication(user.getId(), user.getPassword())) {
            System.out.println(sessionRepository.findById("0393c5bd-8bba-43ba-b450-1bf0946254f3"));

            Session session = sessionRepository.createSession();
            session.setAttribute("uuid", userService.getOneById(user.getId()).get().getUuid());
            sessionRepository.save(session);

            result = session.getId();
        }

        return result;
    }

    @PostMapping("/session-validation")
    public boolean sessionValidation(@RequestBody Map sessionObject) {
        Session session = sessionRepository.findById((String) sessionObject.get("sessionId"));

        if(session==null)
            return false;

        return !session.isExpired();
    }

    @PostMapping("/logout")
    public void logout(@RequestBody String sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
