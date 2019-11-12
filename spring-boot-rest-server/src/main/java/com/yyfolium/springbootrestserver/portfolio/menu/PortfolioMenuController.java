package com.yyfolium.springbootrestserver.portfolio.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PortfolioMenuController {

    @Autowired
    PortfolioMenuService portfolioMenuService;

    @GetMapping("/users/{user_id}/pf-menus")
    public List<PortfolioMenu> getAllPortfolioMenus(@PathVariable String user_id) {
        return portfolioMenuService.getAll(user_id);
    }

    @GetMapping("/users/{user_id}/pf-menus/{id}")
    public Optional<PortfolioMenu> getPortfolioMenuById(@PathVariable String user_id,
                                        @PathVariable(value = "id") Long portfolioMenu_id) {
        return portfolioMenuService.getOneById(user_id, portfolioMenu_id);
    }

    @PostMapping("/users/{user_id}/pf-menus")
    public PortfolioMenu createPortfolioMenu(@PathVariable String user_id,
                             @Valid @RequestBody PortfolioMenu portfolioMenu) {
        return portfolioMenuService.create(user_id, portfolioMenu);
    }

    @PutMapping("/users/{user_id}/pf-menus/{id}")
    public PortfolioMenu updatePortfolioMenu(@PathVariable String user_id,
                             @PathVariable(value = "id") Long portfolioMenu_id,
                             @Valid @RequestBody PortfolioMenu portfolioMenu) {
        return portfolioMenuService.update(user_id, portfolioMenu_id, portfolioMenu);
    }

    @DeleteMapping("/users/{user_id}/pf-menus/{id}")
    public ResponseEntity<?> deletePortfolioMenu(@PathVariable String user_id, @PathVariable(value = "id") Long portfolioMenu_id) {
        portfolioMenuService.deleteById(user_id, portfolioMenu_id);
        return ResponseEntity.ok().build();
    }
}
