package com.yyfolium.springbootrestserver.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioProjectRepository extends JpaRepository<PortfolioProject, Integer> {
}
