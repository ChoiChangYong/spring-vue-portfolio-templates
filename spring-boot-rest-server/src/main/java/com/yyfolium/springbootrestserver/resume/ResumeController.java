package com.yyfolium.springbootrestserver.resume;

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
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @GetMapping("/resumes")
    public List<Resume> getAllResumes(@RequestParam Map requestObject) {
        String sessionId = requestObject.get("sessionId").toString();
        String historyFlag = requestObject.get("historyFlag").toString();

        return resumeService.getAllByUserAndHistoryFlagOrderByStartDate(sessionId, historyFlag);
    }

    @GetMapping("/resumes/{id}")
    public Optional<Resume> getResumeById(@PathVariable(value = "id") Long id) {
        return resumeService.getById(id);
    }

    @PostMapping("/resumes")
    public Resume createResume(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");

        ObjectMapper objectMapper = new ObjectMapper();
        Resume resume = objectMapper.convertValue(requestObject.get("resume"), Resume.class);

        return resumeService.create(sessionObject.get("sessionId").toString(), resume);
    }

    @PutMapping("/resumes")
    public ResponseEntity<?> updateResume(@Valid @RequestBody Map requestObject) {
        resumeService.update((ArrayList<Object>) requestObject.get("resumes"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/resumes/{id}")
    public ResponseEntity<?> deleteResume(@PathVariable(value = "id") Long id) {
        resumeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
