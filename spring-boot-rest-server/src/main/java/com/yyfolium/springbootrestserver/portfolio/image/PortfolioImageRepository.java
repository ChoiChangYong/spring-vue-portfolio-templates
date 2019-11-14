package com.yyfolium.springbootrestserver.portfolio.image;

import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProject;
import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioImageRepository extends JpaRepository<PortfolioImage, Long> {
    List<PortfolioImage> findByPortfolioProjectOrderByCreatedDesc(PortfolioProject portfolioProject);
}
