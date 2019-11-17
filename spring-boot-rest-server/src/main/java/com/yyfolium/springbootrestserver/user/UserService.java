package com.yyfolium.springbootrestserver.user;

import com.yyfolium.springbootrestserver.S3Wrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final SessionRepository sessionRepository;

    @Value("${cloud.aws.s3.bucket.name}")
    private String bucketName;

    @Value("${cloud.aws.s3.bucket.name.profile}")
    private String storeName;

    @Value("${cloud.aws.s3.bucket.endpoint}")
    private String bucketEndpoint;

    private final S3Wrapper s3Wrapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, SessionRepository sessionRepository, S3Wrapper s3Wrapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.sessionRepository = sessionRepository;
        this.s3Wrapper = s3Wrapper;
        this.s3Wrapper.setBucket(bucketName+storeName);
    }

    public Boolean authentication(String id, String password) {
        Optional<User> user = userRepository.findById(id);
        return user.filter(value -> passwordEncoder.matches(password, value.getPassword())).isPresent();
    }

    public User create(User user) {
        User newUser = User.builder()
                .id(user.getId())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getName())
                .gender(user.getGender())
                .email(user.getEmail())
                .tel(user.getTel())
                .imageUrl(user.getImageUrl())
                .build();

        return userRepository.save(newUser);
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getBySessionId(String sessionId) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");
        return userRepository.findByUuid(user_id).get();
    }



    public Optional<User> getOneById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getOneByUuid(String uuid) {
        return userRepository.findByUuid(uuid);
    }



    public User update(String sessionId, User fetchedUser) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        final Optional<User> user = userRepository.findByUuid(user_id);
        if(user.isPresent()){
            Optional.ofNullable(fetchedUser.getName()).ifPresent(f -> user.get().setName(fetchedUser.getName()));
            Optional.ofNullable(fetchedUser.getGender()).ifPresent(f -> user.get().setGender(fetchedUser.getGender()));
            Optional.ofNullable(fetchedUser.getEmail()).ifPresent(f -> user.get().setEmail(fetchedUser.getEmail()));
            Optional.ofNullable(fetchedUser.getTel()).ifPresent(f -> user.get().setTel(fetchedUser.getTel()));
            return userRepository.save(user.get());
        }
        else{
            return null;
        }
    }

    public void profileImageUpload(String sessionId, MultipartFile multipartFile) throws IOException {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");
        Optional<User> user = userRepository.findByUuid(user_id);

        String fileName = UUID.randomUUID().toString().replace("-", "");
        String originName = multipartFile.getOriginalFilename();
        String exc = originName.substring(originName.lastIndexOf(".")+1, originName.length());
        String fileFullPath = bucketEndpoint+storeName+"/"+fileName+"."+exc;

        s3Wrapper.setBucket(bucketName+"/"+storeName);
        s3Wrapper.upload(multipartFile.getInputStream(), fileName+"."+exc);

        user.get().setImageUrl(fileFullPath);
        userRepository.save(user.get());
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
