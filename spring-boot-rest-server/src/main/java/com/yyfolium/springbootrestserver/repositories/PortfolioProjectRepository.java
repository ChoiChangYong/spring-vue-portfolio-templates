package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.PortfolioProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioProjectRepository extends JpaRepository<PortfolioProject, Long> {
}
