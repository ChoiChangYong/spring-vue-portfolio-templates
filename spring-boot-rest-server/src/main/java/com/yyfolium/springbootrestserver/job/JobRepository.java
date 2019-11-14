package com.yyfolium.springbootrestserver.job;

import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByUserOrderByCreatedDesc(User user);
}
