package com.yyfolium.springbootrestserver.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionAttributesRepository extends JpaRepository<SessionAttributes, String> {
}
