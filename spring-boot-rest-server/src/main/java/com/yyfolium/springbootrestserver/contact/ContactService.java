package com.yyfolium.springbootrestserver.contact;

import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserRepository userRepository;

    public Contact create(String user_id, Contact contact) {
        Optional<User> user = userRepository.findByUuid(user_id);
        user.ifPresent(contact::setUser);
        return contactRepository.save(contact);
    }

    public List<Contact> getAll(String user_id) {
        isUser(user_id);
        return contactRepository.findAll();
    }

    public Optional<Contact> getOneById(String user_id, Long contact_id) {
        isUser(user_id);
        return contactRepository.findById(contact_id);
    }

    public Contact update(String user_id, Long contact_id, Contact fetchedContact) {
        isUser(user_id);
        final Optional<Contact> contact = contactRepository.findById(contact_id);
        if(contact.isPresent()){
            Optional.ofNullable(fetchedContact.getName()).ifPresent(f -> contact.get().setName(fetchedContact.getName()));
            Optional.ofNullable(fetchedContact.getEmail()).ifPresent(f -> contact.get().setEmail(fetchedContact.getEmail()));
            Optional.ofNullable(fetchedContact.getTel()).ifPresent(f -> contact.get().setTel(fetchedContact.getTel()));
            Optional.ofNullable(fetchedContact.getMessage()).ifPresent(f -> contact.get().setMessage(fetchedContact.getMessage()));
            return contactRepository.save(contact.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long contact_id) {
        isUser(user_id);
        Optional<Contact> contact = contactRepository.findById(contact_id);
        contact.ifPresent(contactRepository::delete);
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }
}
