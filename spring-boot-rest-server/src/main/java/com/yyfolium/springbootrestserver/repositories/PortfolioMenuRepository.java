package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.PortfolioMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioMenuRepository extends JpaRepository<PortfolioMenu, Long> {
}
