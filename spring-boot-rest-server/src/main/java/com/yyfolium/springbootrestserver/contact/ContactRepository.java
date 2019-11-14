package com.yyfolium.springbootrestserver.contact;

import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByUserOrderByCreatedDesc(User user);
}
