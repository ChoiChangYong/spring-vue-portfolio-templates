package com.yyfolium.springbootrestserver.skill;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    UserRepository userRepository;

    public Skill create(String user_id, Skill skill) {
        Optional<User> user = userRepository.findByUuid(user_id);
        skill.setUser(user.get());
        return skillRepository.save(skill);
    }

    public List<Skill> getAll(String user_id) {
        isUser(user_id);
        return skillRepository.findAll();
    }

    public Optional<Skill> getOneById(String user_id, Long skill_id) {
        isUser(user_id);
        return skillRepository.findById(skill_id);
    }

    public Skill update(String user_id, Long skill_id, Skill fetchedSkill) {
        isUser(user_id);
        final Optional<Skill> skill = skillRepository.findById(skill_id);
        if(skill.isPresent()){
            skill.get().setName(fetchedSkill.getName());
            skill.get().setLevel(fetchedSkill.getLevel());
            return skillRepository.save(skill.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long skill_id) {
        isUser(user_id);
        Optional<Skill> skill = skillRepository.findById(skill_id);
        skillRepository.delete(skill.get());
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }
}
