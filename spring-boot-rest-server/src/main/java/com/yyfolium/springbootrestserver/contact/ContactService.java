package com.yyfolium.springbootrestserver.contact;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyfolium.springbootrestserver.common.GenericServiceWithSessionImpl;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService extends GenericServiceWithSessionImpl<Contact, ContactRepository> {

    public ContactService(ContactRepository contactRepository,
                      UserRepository userRepository,
                      SessionRepository sessionRepository) {
        super(contactRepository, userRepository, sessionRepository);
    }

    @Override
    public Contact create(String sessionId, Contact contact) {
        User user = super.getUserBySessionId(sessionId);
        if(user!=null) {
            contact.setUser(user);
        }
        System.out.println(contact.toString());
        return super.repository.save(contact);
    }

    @Override
    public List<Contact> getAllByUserOrderByCreated(String sessionId) {
        return super.getAllByUserOrderByCreated(sessionId);
    }

    @Override
    public Optional<Contact> getById(Long id) {
        return super.repository.findById(id);
    }

    public void update(ArrayList<Object> fetchedContacts) {
        for(Object o : fetchedContacts){
            ObjectMapper objectMapper = new ObjectMapper();
            Contact fetchedContact = objectMapper.convertValue(o, Contact.class);

            final Optional<Contact> contact = super.repository.findById(fetchedContact.getId());
            if(contact.isPresent()){
                Optional.ofNullable(fetchedContact.getName()).ifPresent(f -> contact.get().setName(fetchedContact.getName()));
                Optional.ofNullable(fetchedContact.getEmail()).ifPresent(f -> contact.get().setEmail(fetchedContact.getEmail()));
                Optional.ofNullable(fetchedContact.getTel()).ifPresent(f -> contact.get().setTel(fetchedContact.getTel()));
                Optional.ofNullable(fetchedContact.getMessage()).ifPresent(f -> contact.get().setMessage(fetchedContact.getMessage()));
                super.repository.save(contact.get());
            }
        }
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
