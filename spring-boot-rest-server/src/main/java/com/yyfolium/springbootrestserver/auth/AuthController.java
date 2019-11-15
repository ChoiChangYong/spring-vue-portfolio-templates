package com.yyfolium.springbootrestserver.auth;

import com.yyfolium.springbootrestserver.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Value("${server.servlet.session.timeout}")
    private int sessionExpiredTime;

    @PostMapping("/login")
    public boolean login(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            HttpSession session) {
        boolean result = false;

        if(userService.authentication(id, password)) {
            session.setAttribute("uuid", userService.getOneById(id).get().getUuid());
            session.setMaxInactiveInterval(sessionExpiredTime);
            result = true;
        }

        return result;
    }

    @PostMapping("/session-validation")
    public boolean sessionValidation(HttpSession session) {
        boolean isExpired;
        if(session.getAttribute("uuid") == null) {
            isExpired = true;
            session.invalidate();
        } else {
            isExpired = false;
        }

        return !isExpired;
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
