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
        System.out.println("requestObject : " + requestObject);
        return skillService.getAllByUserOrderByCreatedDesc(requestObject.get("sessionId").toString());
    }

    @GetMapping("/skills/{id}")
    public Optional<Skill> getSkillById(@PathVariable(value = "id") Long id) {
        System.out.println("id : " + id);
        return skillService.getById(id);
    }

    @PostMapping("/skills")
    public Skill createSkill(@Valid @RequestBody Map requestObject) {
        System.out.println("sessionObject : " + requestObject.get("sessionObject").toString());
        System.out.println("skill : " + requestObject.get("skill").toString());

        Map sessionObject = (Map) requestObject.get("sessionObject");
        Skill skill = (Skill) requestObject.get("skill");

        return skillService.create(sessionObject.get("sessionId").toString(), skill);
    }

    @PutMapping("/skills")
    public ResponseEntity<?> updateSkill(@Valid @RequestBody Skill[] skills) {
        System.out.println("skills : " + skills.toString());
        skillService.update(skills);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable(value = "id") Long id) {
        System.out.println("id : " + id);
        skillService.delete(id);
        return ResponseEntity.ok().build();
    }
}
