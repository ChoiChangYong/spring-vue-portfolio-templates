package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String id);
}
