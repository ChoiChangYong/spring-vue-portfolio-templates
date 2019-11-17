package com.yyfolium.springbootrestserver.skill;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
import com.yyfolium.springbootrestserver.user.User;

import java.util.List;

public interface SkillRepository extends GenericRepositoryJoinUser<Skill> {
    List<Skill> findByUserOrderByCreated(User user);
}
