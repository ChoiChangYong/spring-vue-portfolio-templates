package com.yyfolium.springbootrestserver.portfolio.menu;

import com.yyfolium.springbootrestserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioMenuRepository extends JpaRepository<PortfolioMenu, Long> {
    List<PortfolioMenu> findByUserOrderByCreatedDesc(User user);
}
