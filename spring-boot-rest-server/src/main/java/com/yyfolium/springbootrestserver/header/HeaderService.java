package com.yyfolium.springbootrestserver.header;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeaderService {

    @Autowired
    HeaderRepository headerRepository;

    @Autowired
    UserRepository userRepository;

    public Header create(String user_id, Header header) {
        Optional<User> user = userRepository.findByUuid(user_id);
        user.ifPresent(header::setUser);
        return headerRepository.save(header);
    }

    public List<Header> getAllByUserOrderByCreatedDesc(String user_id) {
        isUser(user_id);
        return headerRepository.findByUserOrderByCreatedDesc(userRepository.findByUuid(user_id).get());
    }

    public Optional<Header> getOneById(String user_id, Long header_id) {
        isUser(user_id);
        return headerRepository.findById(header_id);
    }

    public Header update(String user_id, Long header_id, Header fetchedHeader) {
        isUser(user_id);
        final Optional<Header> header = headerRepository.findById(header_id);
        if(header.isPresent()){
            Optional.ofNullable(fetchedHeader.getTitle()).ifPresent(f -> header.get().setTitle(fetchedHeader.getTitle()));
            Optional.ofNullable(fetchedHeader.getIntro()).ifPresent(f -> header.get().setIntro(fetchedHeader.getIntro()));
            Optional.ofNullable(fetchedHeader.getSubIntro()).ifPresent(f -> header.get().setSubIntro(fetchedHeader.getSubIntro()));
            Optional.ofNullable(fetchedHeader.getBackgroundImageFlag()).ifPresent(f -> header.get().setBackgroundImageFlag(fetchedHeader.getBackgroundImageFlag()));
            return headerRepository.save(header.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long header_id) {
        isUser(user_id);
        Optional<Header> header = headerRepository.findById(header_id);
        header.ifPresent(headerRepository::delete);
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }
}
