package com.yyfolium.springbootrestserver.resume;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.common.GenericServiceWithSessionImpl;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResumeService extends GenericServiceWithSessionImpl<Resume, ResumeRepository> {

    @Autowired
    ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository,
                          UserRepository userRepository,
                          SessionRepository sessionRepository) {
        super(resumeRepository, userRepository, sessionRepository);
    }

    @Override
    public Resume create(String sessionId, Resume resume) {
        User user = super.getUserBySessionId(sessionId);
        if(user!=null) {
            resume.setUser(user);
        }
        System.out.println(resume.toString());
        return super.repository.save(resume);
    }

    public List<Resume> getAllByUserAndHistoryFlagOrderByStartDate(String sessionId, Integer historyFlag) {
        User user = getUserBySessionId(sessionId);
        return resumeRepository.findByUserAndHistoryFlagOrderByStartDate(user, historyFlag);
    }

    @Override
    public Optional<Resume> getById(Long id) {
        return super.repository.findById(id);
    }

    public void update(ArrayList<Object> fetchedResumes) {
        for(Object o : fetchedResumes){
            ObjectMapper objectMapper = new ObjectMapper();
            Resume fetchedResume = objectMapper.convertValue(o, Resume.class);

            final Optional<Resume> resume = super.repository.findById(fetchedResume.getId());
            if(resume.isPresent()){
                Optional.ofNullable(fetchedResume.getJob()).ifPresent(f -> resume.get().setJob(fetchedResume.getJob()));
                Optional.ofNullable(fetchedResume.getCompany()).ifPresent(f -> resume.get().setCompany(fetchedResume.getCompany()));
                Optional.ofNullable(fetchedResume.getDescription()).ifPresent(f -> resume.get().setDescription(fetchedResume.getDescription()));
                Optional.ofNullable(fetchedResume.getStartDate()).ifPresent(f -> resume.get().setStartDate(fetchedResume.getStartDate()));
                Optional.ofNullable(fetchedResume.getEndDate()).ifPresent(f -> resume.get().setEndDate(fetchedResume.getEndDate()));
                Optional.ofNullable(fetchedResume.getHistoryFlag()).ifPresent(f -> resume.get().setHistoryFlag(fetchedResume.getHistoryFlag()));
                super.repository.save(resume.get());
            }
        }
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

}
