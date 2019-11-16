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
    public List<Header> getAllByUserOrderByCreatedDesc(String sessionId) {
        return super.getAllByUserOrderByCreatedDesc(sessionId);
    }

    @Override
    public Optional<Header> getById(Long id) {
        return super.repository.findById(id);
    }

    @Override
    public Header update(Header fetchedHeader) {
        return super.repository.save(fetchedHeader);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
