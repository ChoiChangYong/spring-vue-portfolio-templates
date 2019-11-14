package com.yyfolium.springbootrestserver.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @GetMapping("/users/{user_id}/resumes")
    public List<Resume> getAllResumes(@PathVariable String user_id) {
        return resumeService.getAllByUserOrderByCreatedDesc(user_id);
    }

    @GetMapping("/users/{user_id}/resumes/{id}")
    public Optional<Resume> getResumeById(@PathVariable String user_id,
                                        @PathVariable(value = "id") Long resume_id) {
        return resumeService.getOneById(user_id, resume_id);
    }

    @PostMapping("/users/{user_id}/resumes")
    public Resume createResume(@PathVariable String user_id,
                             @Valid @RequestBody Resume resume) {
        return resumeService.create(user_id, resume);
    }

    @PutMapping("/users/{user_id}/resumes/{id}")
    public Resume updateResume(@PathVariable String user_id,
                             @PathVariable(value = "id") Long resume_id,
                             @Valid @RequestBody Resume resume) {
        return resumeService.update(user_id, resume_id, resume);
    }

    @DeleteMapping("/users/{user_id}/resumes/{id}")
    public ResponseEntity<?> deleteResume(@PathVariable String user_id, @PathVariable(value = "id") Long resume_id) {
        resumeService.deleteById(user_id, resume_id);
        return ResponseEntity.ok().build();
    }
}
