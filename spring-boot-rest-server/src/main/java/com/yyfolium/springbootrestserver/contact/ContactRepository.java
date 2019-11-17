package com.yyfolium.springbootrestserver.contact;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
import com.yyfolium.springbootrestserver.user.User;

import java.util.List;

public interface ContactRepository extends GenericRepositoryJoinUser<Contact> {
    List<Contact> findByUserOrderByCreatedDesc(User user);
}
