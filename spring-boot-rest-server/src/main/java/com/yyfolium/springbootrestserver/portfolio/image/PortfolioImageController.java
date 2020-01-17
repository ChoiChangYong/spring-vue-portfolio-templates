package com.yyfolium.springbootrestserver.portfolio.image;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.session.SessionCheck;
import com.yyfolium.springbootrestserver.storage.StorageService;
import com.yyfolium.springbootrestserver.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PortfolioImageController {

    private final PortfolioImageService portfolioImageService;

    private final UserService userService;

    private final StorageService storageService;

    @Value("${cloud.aws.s3.bucket.endpoint}")
    private String bucketEndpoint;

    @Autowired
    public PortfolioImageController(
            PortfolioImageService portfolioImageService, UserService userService, StorageService storageService) {
        this.portfolioImageService = portfolioImageService;
        this.userService = userService;
        this.storageService = storageService;
    }

    @GetMapping("/anonymous/portfolio-projects/{project_id}/portfolio-images/{uuid}")
    public List<PortfolioImage> getAllSkillsForAnonymous(
            @PathVariable(value = "project_id") Long project_id, @PathVariable(value = "uuid") String uuid) {

        return portfolioImageService.getAllByUuidAndPortfolioProjectOrderByCreated(uuid, project_id);
    }

    @SessionCheck
    @GetMapping("/portfolio-projects/{project_id}/portfolio-images")
    public List<PortfolioImage> getAllPortfolioImages(
            @RequestParam Map requestObject,
            @PathVariable Long project_id) {

        String sessionId = requestObject.get("sessionId").toString();

        return portfolioImageService.getAllBySessionIdAndPortfolioProjectOrderByCreated(sessionId, project_id);
    }


    @SessionCheck
    @GetMapping("/portfolio-projects/{project_id}/portfolio-images/{id}")
    public Optional<PortfolioImage> getPortfolioImageById(
            @Valid @RequestBody Map requestObject,
            @PathVariable Long project_id, @PathVariable(value = "id") Long image_id) {

        String sessionId = requestObject.get("sessionId").toString();
        String userId = userService.getBySessionId(sessionId).getUuid();

        return portfolioImageService.getOneById(userId, project_id, image_id);
    }


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

    @SessionCheck
    @PutMapping("/portfolio-projects/{project_id}/portfolio-images/{id}")
    public PortfolioImage updatePortfolioImage(
            @Valid @RequestBody Map requestObject,
            @PathVariable(value = "project_id") Long project_id, @PathVariable(value = "id") Long image_id) throws IOException {

        String sessionId = requestObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        PortfolioImage portfolioImage = objectMapper.convertValue(requestObject.get("portfolioImage"), PortfolioImage.class);
        return portfolioImageService.update(sessionId, project_id, image_id, portfolioImage);
    }

    @SessionCheck
    @DeleteMapping("/portfolio-projects/{project_id}/portfolio-images/{id}")
    public ResponseEntity<?> deletePortfolioImage(
            @Valid @RequestBody Map requestObject, @PathVariable(value = "project_id") Long project_id, @PathVariable(value = "id") Long image_id) {

        String sessionId = requestObject.get("sessionId").toString();

        portfolioImageService.deleteById(sessionId, project_id, image_id);
        return ResponseEntity.ok().build();
    }

    @SessionCheck
    @PostMapping("/portfolio-projects/{project_id}/image-upload")
    public ResponseEntity<?> profileImageUpload(
            @RequestParam Map requestObject, @PathVariable(value = "project_id") Long project_id, @RequestParam("file") MultipartFile multipartFile) throws IOException {

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
