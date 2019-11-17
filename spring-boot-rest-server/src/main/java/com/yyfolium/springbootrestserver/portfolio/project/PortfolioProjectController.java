package com.yyfolium.springbootrestserver.portfolio.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PortfolioProjectController {

    @Autowired
    PortfolioProjectService portfolioProjectService;

    @GetMapping("/pf-menus/{menu_id}/pf-projects")
    public List<PortfolioProject> getAllPortfolioProjects(
            @RequestParam Map requestObject, @PathVariable Long menu_id) {

        String sessionId = requestObject.get("sessionId").toString();
        return portfolioProjectService.getAllByPortfolioMenuOrderByCreated(sessionId, menu_id);
    }




    @GetMapping("/pf-menus/{menu_id}/pf-projects/{id}")
    public Optional<PortfolioProject> getPortfolioProjectById(
            @PathVariable String user_id, @PathVariable(value = "menu_id") Long menu_id, @PathVariable(value = "id") Long project_id) {
        return portfolioProjectService.getOneById(user_id, menu_id, project_id);
    }




    @PostMapping("/pf-menus/{menu_id}/pf-projects")
    public PortfolioProject createPortfolioProject(
            @RequestBody Map requestObject, @PathVariable(value = "menu_id") Long menu_id) {

        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioProject portfolioProject = objectMapper.convertValue(requestObject.get("portfolioProject"), PortfolioProject.class);

        return portfolioProjectService.create(sessionId, menu_id, portfolioProject);
    }

    @PutMapping("/pf-menus/{menu_id}/pf-projects/{id}")
    public PortfolioProject updatePortfolioProject(
            @Valid @RequestBody Map requestObject, @PathVariable(value = "menu_id") Long menu_id, @PathVariable(value = "id") Long project_id) {

        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioProject portfolioProject = objectMapper.convertValue(requestObject.get("portfolioProject"), PortfolioProject.class);
        return portfolioProjectService.update(sessionId, menu_id, project_id, portfolioProject);
    }

    @DeleteMapping("/pf-menus/{menu_id}/pf-projects/{id}")
    public ResponseEntity<?> deletePortfolioProject(
            @Valid @RequestBody Map sessionObject, @PathVariable(value = "menu_id") Long menu_id, @PathVariable(value = "id") Long project_id) {

        String sessionId = sessionObject.get("sessionId").toString();
        portfolioProjectService.delete(sessionId, menu_id, project_id);
        return ResponseEntity.ok().build();
    }
}
