package com.yyfolium.springbootrestserver.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioImageRepository extends JpaRepository<PortfolioImage, Long> {
}
