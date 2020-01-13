package com.yyfolium.springbootrestserver.job;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
import com.yyfolium.springbootrestserver.user.User;

import java.util.List;

public interface JobRepository extends GenericRepositoryJoinUser<Job> {
    List<Job> findByUserOrderByCreated(User user);
}
