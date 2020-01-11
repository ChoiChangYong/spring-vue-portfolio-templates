package com.yyfolium.springbootrestserver.contact;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.header.Header;
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
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/anonymous/contacts/{uuid}")
    public List<Contact> getAllSkillsForAnonymous(@PathVariable(value = "uuid") String uuid) {
        return contactService.getAllByUuidOrderByCreated(uuid);
    }

    @SessionCheck
    @GetMapping("/contacts")
    public List<Contact> getAllContacts(@RequestParam Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");
        String sessionId = sessionObject.get("sessionId").toString();

        return contactService.getAllBySessionIdOrderByCreated(sessionId);
    }

    @SessionCheck
    @GetMapping("/contacts/{id}")
    public Optional<Contact> getContactById(@Valid @RequestBody Map requestObject, @PathVariable(value = "id") Long id) {
        return contactService.getById(id);
    }

    @SessionCheck
    @PostMapping("/contacts")
    public Contact createContact(@Valid @RequestBody Map requestObject) {
        Map sessionObject = (Map) requestObject.get("sessionObject");

        ObjectMapper objectMapper = new ObjectMapper();
        Contact contact = objectMapper.convertValue(requestObject.get("contact"), Contact.class);

        return contactService.create(sessionObject.get("sessionId").toString(), contact);
    }

    @SessionCheck
    @PutMapping("/contacts")
    public ResponseEntity<?> updateContact(@Valid @RequestBody Map requestObject) {
        contactService.update((ArrayList<Object>) requestObject.get("contacts"));
        return ResponseEntity.ok().build();
    }

    @SessionCheck
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<?> deleteContact(@Valid @RequestBody Map requestObject, @PathVariable(value = "id") Long id) {
        contactService.delete(id);
        return ResponseEntity.ok().build();
    }
}
