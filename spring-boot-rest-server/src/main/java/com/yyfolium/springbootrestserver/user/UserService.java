package com.yyfolium.springbootrestserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User create(User user) {
        User newUser = User.builder()
                .id(user.getId())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getName())
                .gender(user.getGender())
                .email(user.getEmail())
                .tel(user.getTel())
                .build();

        return userRepository.save(newUser);
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getOneByUuid(String uuid) {
        return userRepository.findByUuid(uuid);
    }

    public User update(String uuid, User fetchedUser) {
        final Optional<User> user = userRepository.findByUuid(uuid);
        if(user.isPresent()){
            user.get().setName(fetchedUser.getName());
            user.get().setGender(fetchedUser.getGender());
            user.get().setEmail(fetchedUser.getEmail());
            user.get().setTel(fetchedUser.getTel());
            user.get().setImageUrl(fetchedUser.getImageUrl());

            return userRepository.save(user.get());
        }
        else{
            return null;
        }
    }

    public void deleteByUuid(String uuid) {
        Optional<User> user = userRepository.findByUuid(uuid);
        user.ifPresent(userRepository::delete);
//        userRepository.delete(user.get());
    }

//    @Override
//    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//        User user = userRepository.findById(id)
//            .orElseThrow(() -> new UsernameNotFoundException(id));
//        return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), authorities());
//    }

//    private Collection<? extends GrantedAuthority> authorities() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//    }
}
