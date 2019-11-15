package com.yyfolium.springbootrestserver.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, String> {
    Optional<Session> findBySessionId(String sessionId);
}
