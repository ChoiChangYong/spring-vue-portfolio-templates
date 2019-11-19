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

    @GetMapping("/portfolio-menus/{menu_id}/portfolio-projects")
    public List<PortfolioProject> getAllPortfolioProjects(
            @RequestParam Map requestObject, @PathVariable(value = "menu_id") Long menu_id) {
        System.out.println(requestObject.toString());

        String sessionId = requestObject.get("sessionId").toString();
        return portfolioProjectService.getAllByPortfolioMenuOrderByCreated(sessionId, menu_id);
    }


//    @GetMapping("/portfolio-menus/{menu_id}/portfolio-projects/{id}")
//    public Optional<PortfolioProject> getPortfolioProjectById(
//            @PathVariable String user_id, @PathVariable(value = "menu_id") Long menu_id, @PathVariable(value = "id") Long project_id) {
//        return portfolioProjectService.getOneById(user_id, menu_id, project_id);
//    }


    @PostMapping("/portfolio-menus/{menu_id}/portfolio-projects")
    public PortfolioProject createPortfolioProject(
            @Valid @RequestBody Map requestObject, @PathVariable(value = "menu_id") Long menu_id) {
        System.out.println(requestObject.toString());

        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioProject portfolioProject = objectMapper.convertValue(requestObject.get("portfolioProject"), PortfolioProject.class);

        return portfolioProjectService.create(sessionId, menu_id, portfolioProject);
    }

    @PutMapping("/portfolio-menus/{menu_id}/portfolio-projects/{id}")
    public PortfolioProject updatePortfolioProject(
            @Valid @RequestBody Map requestObject, @PathVariable(value = "menu_id") Long menu_id, @PathVariable(value = "id") Long project_id) {
        System.out.println(requestObject.toString());

        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioProject portfolioProject = objectMapper.convertValue(requestObject.get("portfolioProject"), PortfolioProject.class);
        return portfolioProjectService.update(sessionId, menu_id, project_id, portfolioProject);
    }

    @DeleteMapping("/portfolio-projects/{id}")
    public ResponseEntity<?> deletePortfolioProject(
            @Valid @RequestParam Map sessionObject, @PathVariable(value = "id") Long project_id) {
        System.out.println(sessionObject);
        String sessionId = sessionObject.get("sessionId").toString();
        portfolioProjectService.delete(sessionId, project_id);
        return ResponseEntity.ok().build();
    }
}
