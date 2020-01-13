package com.yyfolium.springbootrestserver.test;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.yyfolium.springbootrestserver.S3Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

//@Controller
public class AwsS3Controller {

    @Autowired
    private S3Wrapper s3Wrapper;

    @GetMapping("/")
    public String listUploadedFiles() {
        return "uploadForm";
    }

    @PostMapping("/")
    public List<PutObjectResult> upload(@RequestParam("file") MultipartFile[] multipartFiles) {
        return s3Wrapper.upload(multipartFiles);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(@RequestParam String key) throws IOException {
        return s3Wrapper.download(key);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<S3ObjectSummary> list() throws IOException {
        return s3Wrapper.list();
    }
}
