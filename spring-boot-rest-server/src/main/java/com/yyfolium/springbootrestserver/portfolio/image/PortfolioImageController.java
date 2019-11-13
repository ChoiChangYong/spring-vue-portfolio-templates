package com.yyfolium.springbootrestserver.portfolio.image;

import com.yyfolium.springbootrestserver.storage.StorageFileNotFoundException;
import com.yyfolium.springbootrestserver.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PortfolioImageController {

    private final PortfolioImageService portfolioImageService;

    private final StorageService storageService;

    @Value("${cloud.aws.s3.bucket.endpoint}")
    private String bucketEndpoint;

    @Autowired
    public PortfolioImageController(
            PortfolioImageService portfolioImageService, StorageService storageService) {
        this.portfolioImageService = portfolioImageService;
        this.storageService = storageService;
    }

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
            @PathVariable String user_id, @PathVariable Long project_id,
            @RequestParam("projectImage") MultipartFile multipartFile) {

        return portfolioImageService.create(user_id, project_id, multipartFile);
    }

    @PutMapping("/users/{user_id}/pf-projects/{project_id}/pf-images/{id}")
    public PortfolioImage updatePortfolioImage(
            @PathVariable String user_id, @PathVariable Long project_id,
            @PathVariable(value = "id") Long image_id,
            @RequestParam("projectImage") MultipartFile multipartFile) throws IOException {
        return portfolioImageService.update(user_id, project_id, image_id, multipartFile);
    }

    @DeleteMapping("/users/{user_id}/pf-projects/{project_id}/pf-images/{id}")
    public ResponseEntity<?> deletePortfolioImage(
            @PathVariable String user_id, @PathVariable Long project_id, @PathVariable(value = "id") Long image_id) {
        portfolioImageService.deleteById(user_id, project_id, image_id);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/files")
    public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
