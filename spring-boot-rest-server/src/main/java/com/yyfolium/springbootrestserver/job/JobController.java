package com.yyfolium.springbootrestserver.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/users/{user_id}/jobs")
    public List<Job> getAllJobs(@PathVariable String user_id) {
        return jobService.getAllByUserOrderByCreatedDesc(user_id);
    }

    @GetMapping("/users/{user_id}/jobs/{id}")
    public Optional<Job> getJobById(@PathVariable String user_id,
                                        @PathVariable(value = "id") Long job_id) {
        return jobService.getOneById(user_id, job_id);
    }

    @PostMapping("/users/{user_id}/jobs")
    public Job createJob(@PathVariable String user_id,
                             @Valid @RequestBody Job job) {
        return jobService.create(user_id, job);
    }

    @PutMapping("/users/{user_id}/jobs/{id}")
    public Job updateJob(@PathVariable String user_id,
                             @PathVariable(value = "id") Long job_id,
                             @Valid @RequestBody Job job) {
        return jobService.update(user_id, job_id, job);
    }

    @DeleteMapping("/users/{user_id}/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable String user_id, @PathVariable(value = "id") Long job_id) {
        jobService.deleteById(user_id, job_id);
        return ResponseEntity.ok().build();
    }
}
