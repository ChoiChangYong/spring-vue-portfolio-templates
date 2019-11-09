package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
