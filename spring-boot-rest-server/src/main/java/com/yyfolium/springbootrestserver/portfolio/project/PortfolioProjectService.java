package com.yyfolium.springbootrestserver.portfolio.project;

import com.yyfolium.springbootrestserver.portfolio.menu.PortfolioMenu;
import com.yyfolium.springbootrestserver.portfolio.menu.PortfolioMenuRepository;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioProjectService {

    @Autowired
    PortfolioProjectRepository portfolioProjectRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PortfolioMenuRepository portfolioMenuRepository;

    public PortfolioProject create(String sessionId, Long menu_id, PortfolioProject portfolioProject) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioMenu(menu_id);

        Optional<PortfolioMenu> portfolioMenu = portfolioMenuRepository.findById(menu_id);
        portfolioMenu.ifPresent(portfolioProject::setPortfolioMenu);

        return portfolioProjectRepository.save(portfolioProject);
    }

    public List<PortfolioProject> getAllByPortfolioMenuOrderByCreated(String sessionId, Long menu_id) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioMenu(menu_id);

        return portfolioProjectRepository.findByPortfolioMenuOrderByCreated(portfolioMenuRepository.findById(menu_id).get());
    }

    public Optional<PortfolioProject> getOneById(String user_id, Long menu_id, Long project_id) {
        isUser(user_id);
        isPortfolioMenu(menu_id);
        return portfolioProjectRepository.findById(project_id);
    }

    public PortfolioProject update(String sessionId, Long menu_id, Long project_id, PortfolioProject fetchedPortfolioProject) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioMenu(menu_id);

        final Optional<PortfolioProject> portfolioProject = portfolioProjectRepository.findById(project_id);
        if(portfolioProject.isPresent()) {
            Optional.ofNullable(fetchedPortfolioProject.getName()).ifPresent(f -> portfolioProject.get().setName(fetchedPortfolioProject.getName()));
            Optional.ofNullable(fetchedPortfolioProject.getDescription()).ifPresent(f -> portfolioProject.get().setDescription(fetchedPortfolioProject.getDescription()));
            return portfolioProjectRepository.save(portfolioProject.get());
        }
        else {
            return null;
        }
    }

    public void delete(String sessionId, Long menu_id, Long project_id) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioMenu(menu_id);
        
        Optional<PortfolioProject> portfolioProject = portfolioProjectRepository.findById(project_id);
        portfolioProject.ifPresent(portfolioProjectRepository::delete);
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }

    public void isPortfolioMenu(Long menu_id){
        portfolioMenuRepository.findById(menu_id)
                .orElseThrow(() -> new UsernameNotFoundException(Long.toString(menu_id)));
    }
}
