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

    @GetMapping("/pf-menus")
    public List<PortfolioMenu> getAllPortfolioMenus(@RequestParam Map requestObject) {
        return portfolioMenuService.getAllByUserOrderByCreated(requestObject.get("sessionId").toString());
    }

    @GetMapping("/pf-menus/{id}")
    public Optional<PortfolioMenu> getPortfolioMenuById(@PathVariable(value = "id") Long id) {
        return portfolioMenuService.getById(id);
    }

    @PostMapping("/pf-menus")
    public PortfolioMenu createPortfolioMenu(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioMenu job = objectMapper.convertValue(requestObject.get("portfolioMenu"), PortfolioMenu.class);

        return portfolioMenuService.create(sessionObject.get("sessionId").toString(), job);
    }

    @PutMapping("/pf-menus")
    public ResponseEntity<?> updatePortfolioMenu(@Valid @RequestBody Map requestObject) {
        portfolioMenuService.update((ArrayList<Object>) requestObject.get("portfolioMenus"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/pf-menus/{id}")
    public ResponseEntity<?> deletePortfolioMenu(@PathVariable(value = "id") Long id) {
        portfolioMenuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
