package com.yyfolium.springbootrestserver.job;

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
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs(@RequestParam Map requestObject) {
        return jobService.getAllByUserOrderByCreatedDesc(requestObject.get("sessionId").toString());
    }

    @GetMapping("/jobs/{id}")
    public Optional<Job> getJobById(@PathVariable(value = "id") Long id) {
        return jobService.getById(id);
    }

    @PostMapping("/jobs")
    public Job createJob(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");

        ObjectMapper objectMapper = new ObjectMapper();
        Job job = objectMapper.convertValue(requestObject.get("skill"), Job.class);

        return jobService.create(sessionObject.get("sessionId").toString(), job);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<?> updateJob(@Valid @RequestBody Map requestObject) {
        jobService.update((ArrayList<Object>) requestObject.get("jobs"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable(value = "id") Long id) {
        jobService.delete(id);
        return ResponseEntity.ok().build();
    }
}
