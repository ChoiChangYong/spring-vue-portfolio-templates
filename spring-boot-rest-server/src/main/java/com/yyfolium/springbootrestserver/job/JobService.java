package com.yyfolium.springbootrestserver.job;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.common.GenericServiceWithSessionImpl;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService extends GenericServiceWithSessionImpl<Job, JobRepository> {

    public JobService(JobRepository jobRepository,
                        UserRepository userRepository,
                        SessionRepository sessionRepository) {
        super(jobRepository, userRepository, sessionRepository);
    }

    @Override
    public Job create(String sessionId, Job job) {
        User user = super.getUserBySessionId(sessionId);
        if(user!=null) {
            job.setUser(user);
        }
        System.out.println(job.toString());
        return super.repository.save(job);
    }

    @Override
    public List<Job> getAllByUserOrderByCreated(String sessionId) {
        return super.getAllByUserOrderByCreated(sessionId);
    }

    @Override
    public Optional<Job> getById(Long id) {
        return super.repository.findById(id);
    }

    public void update(ArrayList<Object> fetchedJobs) {
        for(Object o : fetchedJobs){
            ObjectMapper objectMapper = new ObjectMapper();
            Job fetchedJob = objectMapper.convertValue(o, Job.class);

            final Optional<Job> job = super.repository.findById(fetchedJob.getId());
            if(job.isPresent()){
                Optional.ofNullable(fetchedJob.getName()).ifPresent(f -> job.get().setName(fetchedJob.getName()));
                super.repository.save(job.get());
            }
        }
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
