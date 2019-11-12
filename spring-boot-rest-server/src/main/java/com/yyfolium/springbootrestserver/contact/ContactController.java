package com.yyfolium.springbootrestserver.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/users/{user_id}/contacts")
    public List<Contact> getAllContacts(@PathVariable String user_id) {
        return contactService.getAll(user_id);
    }

    @GetMapping("/users/{user_id}/contacts/{id}")
    public Optional<Contact> getContactById(@PathVariable String user_id,
                                        @PathVariable(value = "id") Long contact_id) {
        return contactService.getOneById(user_id, contact_id);
    }

    @PostMapping("/users/{user_id}/contacts")
    public Contact createContact(@PathVariable String user_id,
                             @Valid @RequestBody Contact contact) {
        return contactService.create(user_id, contact);
    }

    @PutMapping("/users/{user_id}/contacts/{id}")
    public Contact updateContact(@PathVariable String user_id,
                             @PathVariable(value = "id") Long contact_id,
                             @Valid @RequestBody Contact contact) {
        return contactService.update(user_id, contact_id, contact);
    }

    @DeleteMapping("/users/{user_id}/contacts/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable String user_id, @PathVariable(value = "id") Long contact_id) {
        contactService.deleteById(user_id, contact_id);
        return ResponseEntity.ok().build();
    }
}
