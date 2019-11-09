package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
