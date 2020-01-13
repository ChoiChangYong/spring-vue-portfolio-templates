package com.yyfolium.springbootrestserver.resume;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.session.SessionCheck;
import com.yyfolium.springbootrestserver.skill.Skill;
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
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @GetMapping("/anonymous/resumes/{uuid}")
    public List<Resume> getAllSkillsForAnonymous(@PathVariable(value = "uuid") String uuid) {
        return resumeService.getAllByUuidOrderByCreated(uuid);
    }

    @SessionCheck
    @GetMapping("/resumes")
    public List<Resume> getAllResumes(@RequestParam Map requestObject) {
        String sessionId = requestObject.get("sessionId").toString();

        Map resumeObject = (Map) requestObject.get("resumeObject");
        Integer historyFlag = Integer.parseInt(resumeObject.get("historyFlag").toString());

        return resumeService.getAllByUserAndHistoryFlagOrderByStartDate(sessionId, historyFlag);
    }

    @SessionCheck
    @GetMapping("/resumes/{id}")
    public Optional<Resume> getResumeById(@RequestParam Map requestObject, @PathVariable(value = "id") Long id) {
        return resumeService.getById(id);
    }

    @SessionCheck
    @PostMapping("/resumes")
    public Resume createResume(@Valid @RequestBody Map requestObject) {
        String sessionId = requestObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        Resume resume = objectMapper.convertValue(requestObject.get("resume"), Resume.class);

        return resumeService.create(sessionId, resume);
    }

    @SessionCheck
    @PutMapping("/resumes")
    public ResponseEntity<?> updateResume(@Valid @RequestBody Map requestObject) {
        resumeService.update((ArrayList<Object>) requestObject.get("resumes"));
        return ResponseEntity.ok().build();
    }

    @SessionCheck
    @DeleteMapping("/resumes/{id}")
    public ResponseEntity<?> deleteResume(@Valid @RequestBody Map requestObject, @PathVariable(value = "id") Long id) {
        resumeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
