package com.yyfolium.springbootrestserver.skill;

import com.yyfolium.springbootrestserver.common.GenericServiceWithSessionImpl;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService extends GenericServiceWithSessionImpl<Skill, SkillRepository> {

    public SkillService(SkillRepository skillRepository,
                        UserRepository userRepository,
                        SessionRepository sessionRepository) {
        super(skillRepository, userRepository, sessionRepository);
    }

    @Override
    public Skill create(String sessionId, Skill skill) {
        User user = super.getUserBySessionId(sessionId);
        if(user!=null) {
            skill.setUser(user);
        }
        return super.repository.save(skill);
    }

    @Override
    public List<Skill> getAllByUserOrderByCreatedDesc(String sessionId) {
        return super.getAllByUserOrderByCreatedDesc(sessionId);
    }

    @Override
    public Optional<Skill> getById(Long id) {
        return super.repository.findById(id);
    }

    public void update(Skill[] fetchedSkills) {
        for(Skill fetchedSkill : fetchedSkills){
            final Optional<Skill> skill = super.repository.findById(fetchedSkill.getId());
            if(skill.isPresent()){
                Optional.ofNullable(fetchedSkill.getName()).ifPresent(f -> skill.get().setName(fetchedSkill.getName()));
                Optional.ofNullable(fetchedSkill.getLevel()).ifPresent(f -> skill.get().setLevel(fetchedSkill.getLevel()));
                super.repository.save(skill.get());
            }
        }
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
