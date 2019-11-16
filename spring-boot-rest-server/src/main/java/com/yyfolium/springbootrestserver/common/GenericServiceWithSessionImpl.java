package com.yyfolium.springbootrestserver.common;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class GenericServiceWithSessionImpl<T, R extends GenericRepositoryJoinUser<T>> implements GenericServiceWithSession<T> {

    protected final R repository;

    protected final UserRepository userRepository;

    private final SessionRepository sessionRepository;

    @PersistenceContext
    EntityManager entityManager;

    public GenericServiceWithSessionImpl(R repository, UserRepository userRepository, SessionRepository sessionRepository ) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public T create(String sessionId, T t) {
        User user = getUserBySessionId(sessionId);
        return null;
    }

    @Override
    public List<T> getAllByUserOrderByCreatedDesc(String sessionId) {
        User user = getUserBySessionId(sessionId);
        return repository.findByUserOrderByCreatedDesc(user);
    }

    @Override
    public Optional<T> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public T update(T fetchedT) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<T> t = repository.findById(id);
        t.ifPresent(repository::delete);
    }

    protected User getUserBySessionId(String sessionId) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");
        return userRepository.findByUuid(user_id).get();
    }
}
