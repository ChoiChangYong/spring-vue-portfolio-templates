package com.yyfolium.springbootrestserver.portfolio.menu;

import com.yyfolium.springbootrestserver.common.GenericRepositoryJoinUser;
import com.yyfolium.springbootrestserver.user.User;

import java.util.List;

public interface PortfolioMenuRepository extends GenericRepositoryJoinUser<PortfolioMenu> {
    List<PortfolioMenu> findByUserOrderByCreated(User user);
}
