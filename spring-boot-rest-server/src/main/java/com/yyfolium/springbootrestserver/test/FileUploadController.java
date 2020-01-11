package com.yyfolium.springbootrestserver.test;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

import com.yyfolium.springbootrestserver.S3Wrapper;
import com.yyfolium.springbootrestserver.storage.StorageFileNotFoundException;
import com.yyfolium.springbootrestserver.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@RestController
public class FileUploadController {

    @Autowired
    private S3Wrapper s3Wrapper;

    private final StorageService storageService;

    @Value("${cloud.aws.s3.bucket.name}")
    private String bucketName;

    @Value("${cloud.aws.s3.bucket.name.profile}")
    private String storeName;

    @Value("${cloud.aws.s3.bucket.endpoint}")
    private String bucketEndpoint;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

//    @GetMapping("/")
//    public String listUploadedFiles(Model model) throws IOException {
//
//        model.addAttribute("files", storageService.loadAll().map(
//                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//                        "serveFile", path.getFileName().toString()).build().toString())
//                .collect(Collectors.toList()));
//
//        return "uploadForm";
//    }

//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//
//        Resource file = storageService.loadAsResource(filename);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }

//    @PostMapping("/")
//    public String handleFileUpload(@RequestParam("profileImage") MultipartFile multipartFile,
//                                   RedirectAttributes redirectAttributes) throws IOException {
//        String fileName = UUID.randomUUID().toString().replace("-", "");
//        String originName = multipartFile.getOriginalFilename();
//        String exc = originName.substring(originName.lastIndexOf(".")+1, originName.length());
//        String fileFullPath = bucketEndpoint+storeName+"/"+fileName+"."+exc;
//
//        System.out.println(fileFullPath);
//
//        s3Wrapper.setBucket(bucketName+"/"+storeName);
//        s3Wrapper.upload(multipartFile.getInputStream(), fileName+"."+exc);
//
//        storageService.store(multipartFile);
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + multipartFile.getOriginalFilename() + "!");
//
//        return "redirect:/";
//    }

    @PostMapping("/")
    public ResponseEntity<?> testImageUpload(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println("file : " + multipartFile.toString());
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
