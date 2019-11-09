package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.Header;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaderRepository extends JpaRepository<Header, Long> {
}
