package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
