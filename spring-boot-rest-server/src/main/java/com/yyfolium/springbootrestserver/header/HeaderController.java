package com.yyfolium.springbootrestserver.header;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.job.Job;
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
public class HeaderController {

    @Autowired
    HeaderService headerService;

    @GetMapping("/anonymous/headers/{uuid}")
    public List<Header> getAllSkillsForAnonymous(@PathVariable(value = "uuid") String uuid) {
        return headerService.getAllByUuidOrderByCreated(uuid);
    }

    @SessionCheck
    @GetMapping("/headers")
    public List<Header> getAllHeaders(@RequestParam Map requestObject) {
        String sessionId = requestObject.get("sessionId").toString();

        return headerService.getAllBySessionIdOrderByCreated(sessionId);
    }

    @SessionCheck
    @GetMapping("/headers/{id}")
    public Optional<Header> getSkillById(@RequestParam Map requestObject, @PathVariable(value = "id") Long id) {
        return headerService.getById(id);
    }

    @SessionCheck
    @PostMapping("/headers")
    public Header createHeader(@Valid @RequestBody Map requestObject) {
        String sessionId = requestObject.get("sessionId").toString();

        ObjectMapper objectMapper = new ObjectMapper();
        Header header = objectMapper.convertValue(requestObject.get("header"), Header.class);

        return headerService.create(sessionId, header);
    }

    @SessionCheck
    @PutMapping("/headers")
    public ResponseEntity<?> updateHeader(@Valid @RequestBody Map requestObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        Header header = objectMapper.convertValue(requestObject.get("header"), Header.class);

        headerService.update(header);
        return ResponseEntity.ok().build();
    }

    @SessionCheck
    @DeleteMapping("/headers/{id}")
    public ResponseEntity<?> deleteHeader(@Valid @RequestBody Map requestObject, @PathVariable(value = "id") Long id) {
        headerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
