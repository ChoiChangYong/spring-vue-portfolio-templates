package com.yyfolium.springbootrestserver.header;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HeaderController {

    @Autowired
    HeaderService headerService;

    @GetMapping("/headers")
    public List<Header> getAllHeaders(@RequestParam Map requestObject) {
        return headerService.getAllByUserOrderByCreatedDesc(requestObject.get("sessionId").toString());
    }

    @GetMapping("/headers/{id}")
    public Optional<Header> getSkillById(@PathVariable(value = "id") Long id) {
        return headerService.getById(id);
    }

    @PostMapping("/headers")
    public Header createSkill(@RequestParam(value = "sessionObject") Map sessionObject,
                             @RequestParam(value = "skill") Header header) {
        return headerService.create(sessionObject.get("sessionId").toString(), header);
    }

    @PutMapping("/headers")
    public Header updateSkill(@RequestParam(value = "skill") Header header) {
        return headerService.update(header);
    }

    @DeleteMapping("/headers/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable(value = "id") Long id) {
        headerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
