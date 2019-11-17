package com.yyfolium.springbootrestserver.skill;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
        return skillService.getAllByUserOrderByCreated(requestObject.get("sessionId").toString());
    }

    @GetMapping("/skills/{id}")
    public Optional<Skill> getSkillById(@PathVariable(value = "id") Long id) {
        return skillService.getById(id);
    }

    @PostMapping("/skills")
    public Skill createSkill(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");

        ObjectMapper objectMapper = new ObjectMapper();
        Skill skill = objectMapper.convertValue(requestObject.get("skill"), Skill.class);

        return skillService.create(sessionObject.get("sessionId").toString(), skill);
    }

    @PutMapping("/skills")
    public ResponseEntity<?> updateSkill(@Valid @RequestBody Map requestObject) {
        skillService.update((ArrayList<Object>) requestObject.get("skills"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable(value = "id") Long id) {
        skillService.delete(id);
        return ResponseEntity.ok().build();
    }
}
