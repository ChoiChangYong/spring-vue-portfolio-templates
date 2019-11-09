package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
