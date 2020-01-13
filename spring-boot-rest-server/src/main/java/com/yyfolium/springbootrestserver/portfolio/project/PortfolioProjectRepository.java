package com.yyfolium.springbootrestserver.portfolio.project;

import com.yyfolium.springbootrestserver.portfolio.menu.PortfolioMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioProjectRepository extends JpaRepository<PortfolioProject, Long> {
    List<PortfolioProject> findByPortfolioMenuOrderByCreated(PortfolioMenu portfolioMenu);
}
