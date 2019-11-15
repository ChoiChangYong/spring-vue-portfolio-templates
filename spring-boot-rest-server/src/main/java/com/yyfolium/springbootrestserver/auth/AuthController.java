package com.yyfolium.springbootrestserver.auth;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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
    public boolean login(@RequestBody User user, HttpServletResponse response) {
        boolean loginResult = false;

        if(userService.authentication(user.getId(), user.getPassword())) {
            Session session = sessionRepository.createSession();
            session.setAttribute("uuid", userService.getOneById(user.getId()).get().getUuid());
            sessionRepository.save(session);

            Cookie sessionId = new Cookie("sessionId", session.getId());
            response.addCookie(sessionId);
            
            loginResult = true;
        }

        return loginResult;
    }

    @PostMapping("/session-validation")
    public boolean sessionValidation(HttpServletRequest request) {
        AtomicReference<String> sessionId = new AtomicReference<>();

        Cookie[] cookies =  request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("sessionId")) {
                    sessionId.set(c.getValue());
                }
            }
        }

        Session session = sessionRepository.findById(sessionId.get());

        if(session==null)
            return false;

        return !session.isExpired();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie kc = new Cookie("sessionId", null);
        kc.setMaxAge(0);
        response.addCookie(kc);
        return ResponseEntity.ok().build();
    }
}
