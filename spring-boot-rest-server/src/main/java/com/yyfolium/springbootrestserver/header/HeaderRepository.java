package com.yyfolium.springbootrestserver.header;

import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaderRepository extends JpaRepository<Header, Long> {
    List<Header> findByUserOrderByCreatedDesc(User user);
}
