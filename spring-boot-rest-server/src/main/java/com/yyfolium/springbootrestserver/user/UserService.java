package com.yyfolium.springbootrestserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUuid(String uuid) {
        return userRepository.findByUuid(uuid);
    }

    public User update(String userUuid, User userDetails) {
        User user = userRepository.findByUuid(userUuid);

        user.setName(userDetails.getName());
        user.setGender(userDetails.getGender());
        user.setEmail(userDetails.getEmail());
        user.setTel(userDetails.getTel());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public void deleteByUuid(String userUuid) {
        User user = userRepository.findByUuid(userUuid);
        userRepository.delete(user);
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
