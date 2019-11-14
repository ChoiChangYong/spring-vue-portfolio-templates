package com.yyfolium.springbootrestserver.portfolio.menu;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioMenuService {

    @Autowired
    PortfolioMenuRepository portfolioMenuRepository;

    @Autowired
    UserRepository userRepository;

    public PortfolioMenu create(String user_id, PortfolioMenu portfolioMenu) {
        Optional<User> user = userRepository.findByUuid(user_id);
        user.ifPresent(portfolioMenu::setUser);
        return portfolioMenuRepository.save(portfolioMenu);
    }

    public List<PortfolioMenu> getAllByUserOrderByCreatedDesc(String user_id) {
        isUser(user_id);
        return portfolioMenuRepository.findByUserOrderByCreatedDesc(userRepository.findByUuid(user_id).get());
    }

    public Optional<PortfolioMenu> getOneById(String user_id, Long portfolioMenu_id) {
        isUser(user_id);
        return portfolioMenuRepository.findById(portfolioMenu_id);
    }

    public PortfolioMenu update(String user_id, Long portfolioMenu_id, PortfolioMenu fetchedPortfolioMenu) {
        isUser(user_id);
        final Optional<PortfolioMenu> portfolioMenu = portfolioMenuRepository.findById(portfolioMenu_id);
        if(portfolioMenu.isPresent()){
            Optional.ofNullable(fetchedPortfolioMenu.getName()).ifPresent(f -> portfolioMenu.get().setName(fetchedPortfolioMenu.getName()));
            return portfolioMenuRepository.save(portfolioMenu.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long portfolioMenu_id) {
        isUser(user_id);
        Optional<PortfolioMenu> portfolioMenu = portfolioMenuRepository.findById(portfolioMenu_id);
        portfolioMenu.ifPresent(portfolioMenuRepository::delete);
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }
}
