package com.yyfolium.springbootrestserver.header;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HeaderController {

    @Autowired
    HeaderService headerService;

    @GetMapping("/users/{user_id}/headers")
    public List<Header> getAllHeaders(@PathVariable String user_id) {
        return headerService.getAll(user_id);
    }

    @GetMapping("/users/{user_id}/headers/{id}")
    public Optional<Header> getHeaderById(@PathVariable String user_id,
                                        @PathVariable(value = "id") Long header_id) {
        return headerService.getOneById(user_id, header_id);
    }

    @PostMapping("/users/{user_id}/headers")
    public Header createHeader(@PathVariable String user_id,
                             @Valid @RequestBody Header header) {
        return headerService.create(user_id, header);
    }

    @PutMapping("/users/{user_id}/headers/{id}")
    public Header updateHeader(@PathVariable String user_id,
                             @PathVariable(value = "id") Long header_id,
                             @Valid @RequestBody Header header) {
        return headerService.update(user_id, header_id, header);
    }

    @DeleteMapping("/users/{user_id}/headers/{id}")
    public ResponseEntity<?> deleteHeader(@PathVariable String user_id, @PathVariable(value = "id") Long header_id) {
        headerService.deleteById(user_id, header_id);
        return ResponseEntity.ok().build();
    }
}
