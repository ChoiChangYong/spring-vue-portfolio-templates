package com.yyfolium.springbootrestserver.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    SessionRepository sessionRepository;

    public Optional<Session> getAllById(String sessionId) {
        return sessionRepository.findBySessionId(sessionId);
    }

}
