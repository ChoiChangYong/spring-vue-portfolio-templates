package com.yyfolium.springbootrestserver.portfolio.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PortfolioProjectController {

    @Autowired
    PortfolioProjectService portfolioProjectService;

    @GetMapping("/users/{user_id}/pf-menus/{menu_id}/pf-projects")
    public List<PortfolioProject> getAllPortfolioProjects(
            @PathVariable String user_id, @PathVariable Long menu_id) {
        return portfolioProjectService.getAllByPortfolioMenuOrderByCreated(user_id, menu_id);
    }

    @GetMapping("/users/{user_id}/pf-menus/{menu_id}/pf-projects/{id}")
    public Optional<PortfolioProject> getPortfolioProjectById(
            @PathVariable String user_id, @PathVariable Long menu_id, @PathVariable(value = "id") Long project_id) {
        return portfolioProjectService.getOneById(user_id, menu_id, project_id);
    }

    @PostMapping("/users/{user_id}/pf-menus/{menu_id}/pf-projects")
    public PortfolioProject createPortfolioProject(
            @PathVariable String user_id, @PathVariable Long menu_id, @Valid @RequestBody PortfolioProject portfolioProject) {
        return portfolioProjectService.create(user_id, menu_id, portfolioProject);
    }

    @PutMapping("/users/{user_id}/pf-menus/{menu_id}/pf-projects/{id}")
    public PortfolioProject updatePortfolioProject(
            @PathVariable String user_id, @PathVariable Long menu_id,
            @PathVariable(value = "id") Long project_id, @Valid @RequestBody PortfolioProject portfolioProject) {
        return portfolioProjectService.update(user_id, menu_id, project_id, portfolioProject);
    }

    @DeleteMapping("/users/{user_id}/pf-menus/{menu_id}/pf-projects/{id}")
    public ResponseEntity<?> deletePortfolioProject(
            @PathVariable String user_id, @PathVariable Long menu_id, @PathVariable(value = "id") Long project_id) {
        portfolioProjectService.deleteById(user_id, menu_id, project_id);
        return ResponseEntity.ok().build();
    }
}
