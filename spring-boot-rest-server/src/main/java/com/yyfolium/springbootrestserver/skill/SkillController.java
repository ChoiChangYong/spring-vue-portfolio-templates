package com.yyfolium.springbootrestserver.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/users/{user_id}/skills")
    public List<Skill> getAllSkills(@PathVariable String user_id) {
        return skillService.getAllByUserOrderByCreatedDesc(user_id);
    }

    @GetMapping("/users/{user_id}/skills/{id}")
    public Optional<Skill> getSkillById(@PathVariable String user_id,
                                        @PathVariable(value = "id") Long skill_id) {
        return skillService.getOneById(user_id, skill_id);
    }

    @PostMapping("/users/{user_id}/skills")
    public Skill createSkill(@PathVariable String user_id,
                             @Valid @RequestBody Skill skill) {
        return skillService.create(user_id, skill);
    }

    @PutMapping("/users/{user_id}/skills/{id}")
    public Skill updateSkill(@PathVariable String user_id,
                             @PathVariable(value = "id") Long skill_id,
                             @Valid @RequestBody Skill skill) {
        return skillService.update(user_id, skill_id, skill);
    }

    @DeleteMapping("/users/{user_id}/skills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable String user_id, @PathVariable(value = "id") Long skill_id) {
        skillService.deleteById(user_id, skill_id);
        return ResponseEntity.ok().build();
    }
}
