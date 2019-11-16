package com.yyfolium.springbootrestserver.header;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        System.out.println("requestObject : " + requestObject);
        return headerService.getAllByUserOrderByCreatedDesc(requestObject.get("sessionId").toString());
    }

    @GetMapping("/headers/{id}")
    public Optional<Header> getSkillById(@PathVariable(value = "id") Long id) {
        System.out.println("id : " + id);
        return headerService.getById(id);
    }

    @PostMapping("/headers")
    public Header createHeader(@Valid @RequestBody Map requestObject) {
        System.out.println("sessionObject : " + requestObject.get("sessionObject").toString());
        System.out.println("header : " + requestObject.get("header").toString());

        Map sessionObject = (Map) requestObject.get("sessionObject");
        Header header = (Header) requestObject.get("header");

        return headerService.create(sessionObject.get("sessionId").toString(), header);
    }

    @PutMapping("/headers")
    public Header updateHeader(@Valid @RequestBody Header header) {
        System.out.println("header : " + header.toString());
        return headerService.update(header);
    }

    @DeleteMapping("/headers/{id}")
    public ResponseEntity<?> deleteHeader(@PathVariable(value = "id") Long id) {
        System.out.println("id : " + id);
        headerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
