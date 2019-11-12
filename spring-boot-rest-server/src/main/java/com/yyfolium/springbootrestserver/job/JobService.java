package com.yyfolium.springbootrestserver.job;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserRepository userRepository;

    public Job create(String user_id, Job job) {
        Optional<User> user = userRepository.findByUuid(user_id);
        user.ifPresent(job::setUser);
        return jobRepository.save(job);
    }

    public List<Job> getAll(String user_id) {
        isUser(user_id);
        return jobRepository.findAll();
    }

    public Optional<Job> getOneById(String user_id, Long job_id) {
        isUser(user_id);
        return jobRepository.findById(job_id);
    }

    public Job update(String user_id, Long job_id, Job fetchedJob) {
        isUser(user_id);
        final Optional<Job> job = jobRepository.findById(job_id);
        if(job.isPresent()){
            Optional.ofNullable(fetchedJob.getName()).ifPresent(f -> job.get().setName(fetchedJob.getName()));
            return jobRepository.save(job.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long job_id) {
        isUser(user_id);
        Optional<Job> job = jobRepository.findById(job_id);
        job.ifPresent(jobRepository::delete);
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }
}
