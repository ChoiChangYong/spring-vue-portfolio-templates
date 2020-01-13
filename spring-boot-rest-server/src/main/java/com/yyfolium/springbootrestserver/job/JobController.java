package com.yyfolium.springbootrestserver.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.resume.Resume;
import com.yyfolium.springbootrestserver.session.SessionCheck;
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
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/anonymous/jobs/{uuid}")
    public List<Job> getAllSkillsForAnonymous(@PathVariable(value = "uuid") String uuid) {
        return jobService.getAllByUuidOrderByCreated(uuid);
    }

    @SessionCheck
    @GetMapping("/jobs")
    public List<Job> getAllJobs(@RequestParam Map requestObject) {
        String sessionId = requestObject.get("sessionId").toString();

        return jobService.getAllBySessionIdOrderByCreated(sessionId);
    }

    @SessionCheck
    @GetMapping("/jobs/{id}")
    public Optional<Job> getJobById(@RequestParam Map requestObject, @PathVariable(value = "id") Long id) {
        return jobService.getById(id);
    }

    @SessionCheck
    @PostMapping("/jobs")
    public Job createJob(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");

        ObjectMapper objectMapper = new ObjectMapper();
        Job job = objectMapper.convertValue(requestObject.get("job"), Job.class);

        return jobService.create(sessionObject.get("sessionId").toString(), job);
    }

    @SessionCheck
    @PutMapping("/jobs")
    public ResponseEntity<?> updateJob(@Valid @RequestBody Map requestObject) {
        jobService.update((ArrayList<Object>) requestObject.get("jobs"));
        return ResponseEntity.ok().build();
    }

    @SessionCheck
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJob(@Valid @RequestBody Map requestObject, @PathVariable(value = "id") Long id) {
        jobService.delete(id);
        return ResponseEntity.ok().build();
    }
}
