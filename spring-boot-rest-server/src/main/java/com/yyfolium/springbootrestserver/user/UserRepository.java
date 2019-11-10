package com.yyfolium.springbootrestserver.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUuid(String uuid);
}
