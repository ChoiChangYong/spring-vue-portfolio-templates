package com.yyfolium.springbootrestserver.portfolio.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProject;
import com.yyfolium.springbootrestserver.session.SessionCheck;
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
public class PortfolioMenuController {

    @Autowired
    PortfolioMenuService portfolioMenuService;

    @GetMapping("/anonymous/portfolio-menus/{uuid}")
    public List<PortfolioMenu> getAllSkillsForAnonymous(
            @PathVariable(value = "uuid") String uuid) {

        return portfolioMenuService.getAllByUuidOrderByCreated(uuid);
    }

    @SessionCheck
    @GetMapping("/portfolio-menus")
    public List<PortfolioMenu> getAllPortfolioMenus(@RequestParam Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        return portfolioMenuService.getAllBySessionIdOrderByCreated(sessionId);
    }

    @SessionCheck
    @GetMapping("/portfolio-menus/{id}")
    public Optional<PortfolioMenu> getPortfolioMenuById(
            @RequestParam Map requestObject,
            @PathVariable(value = "id") Long id) {
        return portfolioMenuService.getById(id);
    }

    @SessionCheck
    @PostMapping("/portfolio-menus")
    public PortfolioMenu createPortfolioMenu(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioMenu portfolioMenu = objectMapper.convertValue(requestObject.get("portfolioMenu"), PortfolioMenu.class);

        return portfolioMenuService.create(sessionId, portfolioMenu);
    }

    @SessionCheck
    @PutMapping("/portfolio-menus")
    public ResponseEntity<?> updatePortfolioMenu(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        Map portfolioMenuObject = (Map) requestObject.get("portfolioMenus");

        ArrayList<Object> portfolioMenus = (ArrayList<Object>) portfolioMenuObject.get("portfolioMenus");
        portfolioMenuService.update(sessionId, portfolioMenus);
        return ResponseEntity.ok().build();
    }

    @SessionCheck
    @DeleteMapping("/portfolio-menus/{id}")
    public ResponseEntity<?> deletePortfolioMenu(
            @Valid @RequestParam Map requestObject, @PathVariable(value = "id") Long id) {

        portfolioMenuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
