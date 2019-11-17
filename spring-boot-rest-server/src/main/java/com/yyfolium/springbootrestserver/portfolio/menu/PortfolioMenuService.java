package com.yyfolium.springbootrestserver.portfolio.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.common.GenericServiceWithSessionImpl;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioMenuService extends GenericServiceWithSessionImpl<PortfolioMenu, PortfolioMenuRepository> {

    public PortfolioMenuService(PortfolioMenuRepository portfolioMenuRepository,
                      UserRepository userRepository,
                      SessionRepository sessionRepository) {
        super(portfolioMenuRepository, userRepository, sessionRepository);
    }

    @Override
    public PortfolioMenu create(String sessionId, PortfolioMenu portfolioMenu) {
        User user = super.getUserBySessionId(sessionId);
        if(user!=null) {
            portfolioMenu.setUser(user);
        }
        System.out.println(portfolioMenu.toString());
        return super.repository.save(portfolioMenu);
    }

    @Override
    public List<PortfolioMenu> getAllByUserOrderByCreated(String sessionId) {
        return super.getAllByUserOrderByCreated(sessionId);
    }

    @Override
    public Optional<PortfolioMenu> getById(Long id) {
        return super.repository.findById(id);
    }

    public void update(ArrayList<Object> fetchedPortfolioMenus) {
        for(Object o : fetchedPortfolioMenus){
            ObjectMapper objectMapper = new ObjectMapper();
            PortfolioMenu fetchedPortfolioMenu = objectMapper.convertValue(o, PortfolioMenu.class);

            final Optional<PortfolioMenu> portfolioMenu = super.repository.findById(fetchedPortfolioMenu.getId());
            if(portfolioMenu.isPresent()){
                Optional.ofNullable(fetchedPortfolioMenu.getName()).ifPresent(f -> portfolioMenu.get().setName(fetchedPortfolioMenu.getName()));
                super.repository.save(portfolioMenu.get());
            }
        }
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

}
