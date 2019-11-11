package com.yyfolium.springbootrestserver.resume;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    UserRepository userRepository;

    public Resume create(String user_id, Resume resume) {
        Optional<User> user = userRepository.findByUuid(user_id);
        resume.setUser(user.get());
        return resumeRepository.save(resume);
    }

    public List<Resume> getAll(String user_id) {
        isUser(user_id);
        return resumeRepository.findAll();
    }

    public Optional<Resume> getOneById(String user_id, Long resume_id) {
        isUser(user_id);
        return resumeRepository.findById(resume_id);
    }

    public Resume update(String user_id, Long resume_id, Resume fetchedResume) {
        isUser(user_id);
        final Optional<Resume> resume = resumeRepository.findById(resume_id);
        if(resume.isPresent()){
            resume.get().setJob(fetchedResume.getJob());
            resume.get().setCompany(fetchedResume.getCompany());
            resume.get().setDescription(fetchedResume.getDescription());
            resume.get().setStartDate(fetchedResume.getStartDate());
            resume.get().setEndDate(fetchedResume.getEndDate());
            resume.get().setHistoryFlag(fetchedResume.getHistoryFlag());
            return resumeRepository.save(resume.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long resume_id) {
        isUser(user_id);
        Optional<Resume> resume = resumeRepository.findById(resume_id);
        resumeRepository.delete(resume.get());
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }
}
