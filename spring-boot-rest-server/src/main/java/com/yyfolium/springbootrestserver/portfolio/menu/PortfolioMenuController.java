package com.yyfolium.springbootrestserver.portfolio.menu;

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
public class PortfolioMenuController {

    @Autowired
    PortfolioMenuService portfolioMenuService;

    @GetMapping("/portfolio-menus")
    public List<PortfolioMenu> getAllPortfolioMenus(@RequestParam Map requestObject) {
        System.out.println(requestObject.toString());

        return portfolioMenuService.getAllByUserOrderByCreated(requestObject.get("sessionId").toString());
    }

    @GetMapping("/portfolio-menus/{id}")
    public Optional<PortfolioMenu> getPortfolioMenuById(@PathVariable(value = "id") Long id) {
        return portfolioMenuService.getById(id);
    }

    @PostMapping("/portfolio-menus")
    public PortfolioMenu createPortfolioMenu(@Valid @RequestBody Map requestObject) {
        System.out.println(requestObject.toString());

        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioMenu portfolioMenu = objectMapper.convertValue(requestObject.get("portfolioMenu"), PortfolioMenu.class);

        return portfolioMenuService.create(sessionId, portfolioMenu);
    }

    @PutMapping("/portfolio-menus")
    public ResponseEntity<?> updatePortfolioMenu(@Valid @RequestBody Map requestObject) {
        System.out.println(requestObject.toString());

        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        Map portfolioMenuObject = (Map) requestObject.get("portfolioMenus");

        ArrayList<Object> portfolioMenus = (ArrayList<Object>) portfolioMenuObject.get("portfolioMenus");
        portfolioMenuService.update(sessionId, portfolioMenus);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/portfolio-menus/{id}")
    public ResponseEntity<?> deletePortfolioMenu(@PathVariable(value = "id") Long id) {
        portfolioMenuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
