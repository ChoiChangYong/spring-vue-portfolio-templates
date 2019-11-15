package com.yyfolium.springbootrestserver.auth;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

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
    public String login(
            @RequestBody User user,
            HttpSession session) {
        String result = "0";

        if(userService.authentication(user.getId(), user.getPassword())) {
            session.setAttribute("uuid", userService.getOneById(user.getId()).get().getUuid());
            session.setMaxInactiveInterval(sessionExpiredTime);
            result = session.getId();
        }

        return result;
    }

    @PostMapping("/session-validation")
    public boolean sessionValidation(@RequestBody String sessionId) {
        System.out.println("sessionId : " + sessionId);

        Optional<Session> session = sessionRepository.findBySessionId(sessionId);
        System.out.println(session.toString());

        return !session.isPresent();
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
