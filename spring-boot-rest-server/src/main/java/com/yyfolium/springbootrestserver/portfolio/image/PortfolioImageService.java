package com.yyfolium.springbootrestserver.portfolio.image;

import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProject;
import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProjectRepository;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioImageService {

    @Autowired
    PortfolioImageRepository portfolioImageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PortfolioProjectRepository portfolioProjectRepository;

    public PortfolioImage create(String user_id, Long project_id, PortfolioImage portfolioImage) {
        isUser(user_id);
        Optional<PortfolioProject> portfolioProject = portfolioProjectRepository.findById(project_id);
        portfolioProject.ifPresent(portfolioImage::setPortfolioProject);
        return portfolioImageRepository.save(portfolioImage);
    }

    public List<PortfolioImage> getAll(String user_id, Long project_id) {
        isUser(user_id);
        isPortfolioProject(project_id);
        return portfolioImageRepository.findAll();
    }

    public Optional<PortfolioImage> getOneById(String user_id, Long project_id, Long image_id) {
        isUser(user_id);
        isPortfolioProject(project_id);
        return portfolioImageRepository.findById(image_id);
    }

    public PortfolioImage update(String user_id, Long project_id, Long image_id, PortfolioImage fetchedPortfolioImage) {
        isUser(user_id);
        isPortfolioProject(project_id);
        final Optional<PortfolioImage> portfolioImage = portfolioImageRepository.findById(image_id);
        if(portfolioImage.isPresent()){
            Optional.ofNullable(fetchedPortfolioImage.getUrl()).ifPresent(f -> portfolioImage.get().setUrl(fetchedPortfolioImage.getUrl()));
            return portfolioImageRepository.save(portfolioImage.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long project_id, Long image_id) {
        isUser(user_id);
        isPortfolioProject(project_id);
        Optional<PortfolioImage> portfolioImage = portfolioImageRepository.findById(image_id);
        portfolioImage.ifPresent(portfolioImageRepository::delete);
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }

    public void isPortfolioProject(Long project_id){
        portfolioProjectRepository.findById(project_id)
                .orElseThrow(() -> new UsernameNotFoundException(Long.toString(project_id)));
    }
}
