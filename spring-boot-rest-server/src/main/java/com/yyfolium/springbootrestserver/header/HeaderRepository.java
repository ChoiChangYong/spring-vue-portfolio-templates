package com.yyfolium.springbootrestserver.header;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
import com.yyfolium.springbootrestserver.user.User;

import java.util.List;

public interface HeaderRepository extends GenericRepositoryJoinUser<Header> {
    List<Header> findByUserOrderByCreatedDesc(User user);
}
