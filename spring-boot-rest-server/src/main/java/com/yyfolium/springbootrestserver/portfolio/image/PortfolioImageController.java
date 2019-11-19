package com.yyfolium.springbootrestserver.portfolio.image;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/portfolio-projects/{project_id}/portfolio-images")
    public List<PortfolioImage> getAllPortfolioImages(
            @RequestParam Map requestObject, @PathVariable Long project_id) {
        System.out.println(requestObject.toString());

        String sessionId = requestObject.get("sessionId").toString();
        return portfolioImageService.getAllByPortfolioProjectOrderByCreated(sessionId, project_id);
    }


//    @GetMapping("/portfolio-projects/{project_id}/portfolio-images/{id}")
//    public Optional<PortfolioImage> getPortfolioImageById(
//            @PathVariable String user_id, @PathVariable Long project_id, @PathVariable(value = "id") Long image_id) {
//        return portfolioImageService.getOneById(user_id, project_id, image_id);
//    }


//    @PostMapping("/portfolio-projects/{project_id}/portfolio-images")
//    public PortfolioImage createPortfolioImage(
//            @RequestBody Map requestObject, @PathVariable(value = "project_id") Long project_id) {
//
//        Map sessionObject = (Map) requestObject.get("sessionObject");
//        String sessionId = sessionObject.get("sessionId").toString();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        PortfolioImage portfolioImage = objectMapper.convertValue(requestObject.get("portfolioImage"), PortfolioImage.class);
//
//        return portfolioImageService.create(sessionId, project_id, portfolioImage);
//    }

    @PutMapping("/portfolio-projects/{project_id}/portfolio-images/{id}")
    public PortfolioImage updatePortfolioImage(
            @Valid @RequestBody Map requestObject,
            @PathVariable(value = "project_id") Long project_id, @PathVariable(value = "id") Long image_id) throws IOException {

        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioImage portfolioImage = objectMapper.convertValue(requestObject.get("portfolioImage"), PortfolioImage.class);
        return portfolioImageService.update(sessionId, project_id, image_id, portfolioImage);
    }

    @DeleteMapping("/portfolio-projects/{project_id}/portfolio-images/{id}")
    public ResponseEntity<?> deletePortfolioImage(
            @Valid @RequestBody Map sessionObject, @PathVariable(value = "project_id") Long project_id, @PathVariable(value = "id") Long image_id) {

        String sessionId = sessionObject.get("sessionId").toString();
        portfolioImageService.deleteById(sessionId, project_id, image_id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/portfolio-projects/{project_id}/image-upload")
    public ResponseEntity<?> profileImageUpload(
            @RequestParam Map requestObject, @PathVariable(value = "project_id") Long project_id, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println(requestObject.toString());

        String sessionId = requestObject.get("sessionId").toString();

        portfolioImageService.projectImageUpload(sessionId, project_id, multipartFile);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//
//        Resource file = storageService.loadAsResource(filename);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }
//
//    @PostMapping("/files")
//    public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file,
//                                                   RedirectAttributes redirectAttributes) {
//
//        storageService.store(file);
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return ResponseEntity.ok().build();
//    }
//
//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }
}
