package com.yyfolium.springbootrestserver.portfolio.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PortfolioImageController {

    @Autowired
    PortfolioImageService portfolioImageService;

    @GetMapping("/users/{user_id}/pf-projects/{project_id}/pf-images")
    public List<PortfolioImage> getAllPortfolioImages(
            @PathVariable String user_id, @PathVariable Long project_id) {
        return portfolioImageService.getAll(user_id, project_id);
    }

    @GetMapping("/users/{user_id}/pf-projects/{project_id}/pf-images/{id}")
    public Optional<PortfolioImage> getPortfolioImageById(
            @PathVariable String user_id, @PathVariable Long project_id, @PathVariable(value = "id") Long image_id) {
        return portfolioImageService.getOneById(user_id, project_id, image_id);
    }

    @PostMapping("/users/{user_id}/pf-projects/{project_id}/pf-images")
    public PortfolioImage createPortfolioImage(
            @PathVariable String user_id, @PathVariable Long project_id, @Valid @RequestBody PortfolioImage portfolioImage) {
        return portfolioImageService.create(user_id, project_id, portfolioImage);
    }

    @PutMapping("/users/{user_id}/pf-projects/{project_id}/pf-images/{id}")
    public PortfolioImage updatePortfolioImage(
            @PathVariable String user_id, @PathVariable Long project_id,
            @PathVariable(value = "id") Long image_id, @Valid @RequestBody PortfolioImage portfolioImage) {
        return portfolioImageService.update(user_id, project_id, image_id, portfolioImage);
    }

    @DeleteMapping("/users/{user_id}/pf-projects/{project_id}/pf-images/{id}")
    public ResponseEntity<?> deletePortfolioImage(
            @PathVariable String user_id, @PathVariable Long project_id, @PathVariable(value = "id") Long image_id) {
        portfolioImageService.deleteById(user_id, project_id, image_id);
        return ResponseEntity.ok().build();
    }
}
