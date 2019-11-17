package com.yyfolium.springbootrestserver.common;

import java.util.List;
import java.util.Optional;

public interface GenericServiceWithSession<T> {
    T create(String sessionId, T t);
    List<T> getAllByUserOrderByCreated(String sessionId);
    Optional<T> getById(Long id);
    T update(T fetchedT);
    void delete(Long id);
}
