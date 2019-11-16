package com.yyfolium.springbootrestserver.skill;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends GenericRepositoryJoinUser<Skill> {
    List<Skill> findByUserOrderByCreatedDesc(User user);
}
