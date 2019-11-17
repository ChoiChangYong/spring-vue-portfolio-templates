package com.yyfolium.springbootrestserver.header;

import com.yyfolium.springbootrestserver.common.GenericServiceWithSessionImpl;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeaderService extends GenericServiceWithSessionImpl<Header, HeaderRepository> {

    public HeaderService(HeaderRepository headerRepository,
                        UserRepository userRepository,
                        SessionRepository sessionRepository) {
        super(headerRepository, userRepository, sessionRepository);
    }

    @Override
    public Header create(String sessionId, Header header) {
        User user = super.getUserBySessionId(sessionId);
        if(user!=null) {
            header.setUser(user);
        }
        return super.repository.save(header);
    }

    @Override
    public List<Header> getAllByUserOrderByCreated(String sessionId) {
        return super.getAllByUserOrderByCreated(sessionId);
    }

    @Override
    public Optional<Header> getById(Long id) {
        return super.repository.findById(id);
    }

    @Override
    public Header update(Header fetchedHeader) {
        final Optional<Header> header = super.repository.findById(fetchedHeader.getId());
        if(header.isPresent()){
            Optional.ofNullable(fetchedHeader.getTitle()).ifPresent(f -> header.get().setTitle(fetchedHeader.getTitle()));
            Optional.ofNullable(fetchedHeader.getIntro()).ifPresent(f -> header.get().setIntro(fetchedHeader.getIntro()));
            Optional.ofNullable(fetchedHeader.getSubIntro()).ifPresent(f -> header.get().setSubIntro(fetchedHeader.getSubIntro()));
            Optional.ofNullable(fetchedHeader.getBackgroundImageFlag()).ifPresent(f -> header.get().setBackgroundImageFlag(fetchedHeader.getBackgroundImageFlag()));
            return super.repository.save(header.get());
        }
        else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
