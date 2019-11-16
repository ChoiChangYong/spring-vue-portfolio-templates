package com.yyfolium.springbootrestserver.common;

import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface GenericRepositoryJoinUser<T> extends JpaRepository<T, Long> {
    List<T> findByUserOrderByCreatedDesc(User user);
}
