package com.yyfolium.springbootrestserver.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("skills")
    public List<Skill> getAllSkills(@RequestParam Map requestObject) {
        return skillService.getAllByUserOrderByCreatedDesc(requestObject.get("sessionId").toString());
    }

    @GetMapping("/skills/{id}")
    public Optional<Skill> getSkillById(@PathVariable(value = "id") Long id) {
        return skillService.getById(id);
    }

    @PostMapping("/skills")
    public Skill createSkill(@RequestParam(value = "sessionObject") Map sessionObject,
                             @RequestParam(value = "skill") Skill skill) {
        return skillService.create(sessionObject.get("sessionId").toString(), skill);
    }

    @PutMapping("/skills")
    public Skill updateSkill(@RequestParam(value = "skill") Skill skill) {
        return skillService.update(skill);
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable(value = "id") Long id) {
        skillService.delete(id);
        return ResponseEntity.ok().build();
    }
}
