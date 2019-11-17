package com.yyfolium.springbootrestserver.contact;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts(@RequestParam Map requestObject) {
        return contactService.getAllByUserOrderByCreatedDesc(requestObject.get("sessionId").toString());
    }

    @GetMapping("/contacts/{id}")
    public Optional<Contact> getContactById(@PathVariable(value = "id") Long id) {
        return contactService.getById(id);
    }

    @PostMapping("/contacts")
    public Contact createContact(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");

        ObjectMapper objectMapper = new ObjectMapper();
        Contact contact = objectMapper.convertValue(requestObject.get("contact"), Contact.class);

        return contactService.create(sessionObject.get("sessionId").toString(), contact);
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<?> updateContact(@Valid @RequestBody Map requestObject) {
        contactService.update((ArrayList<Object>) requestObject.get("contacts"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable(value = "id") Long id) {
        contactService.delete(id);
        return ResponseEntity.ok().build();
    }
}
