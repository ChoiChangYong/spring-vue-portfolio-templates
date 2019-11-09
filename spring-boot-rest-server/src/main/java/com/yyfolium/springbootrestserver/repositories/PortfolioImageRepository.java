package com.yyfolium.springbootrestserver.repositories;

import com.yyfolium.springbootrestserver.models.PortfolioImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioImageRepository extends JpaRepository<PortfolioImage, Long> {
}
