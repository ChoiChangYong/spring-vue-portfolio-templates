package com.yyfolium.springbootrestserver.job;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends GenericRepositoryJoinUser<Job> {
    List<Job> findByUserOrderByCreatedDesc(User user);
}
