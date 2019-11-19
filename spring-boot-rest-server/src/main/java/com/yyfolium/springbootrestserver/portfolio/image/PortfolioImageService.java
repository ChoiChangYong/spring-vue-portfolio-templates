package com.yyfolium.springbootrestserver.portfolio.image;

import com.yyfolium.springbootrestserver.S3Wrapper;
import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProject;
import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProjectRepository;
import com.yyfolium.springbootrestserver.user.User;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PortfolioImageService {

    private final PortfolioImageRepository portfolioImageRepository;

    private final SessionRepository sessionRepository;

    private final UserRepository userRepository;

    private final PortfolioProjectRepository portfolioProjectRepository;

    @Value("${cloud.aws.s3.bucket.name}")
    private String bucketName;

    @Value("${cloud.aws.s3.bucket.name.project}")
    private String storeName;

    @Value("${cloud.aws.s3.bucket.endpoint}")
    private String bucketEndpoint;

    private final S3Wrapper s3Wrapper;

    public PortfolioImageService(PortfolioImageRepository portfolioImageRepository,
                                 SessionRepository sessionRepository, UserRepository userRepository,
                                 PortfolioProjectRepository portfolioProjectRepository,
                                 S3Wrapper s3Wrapper) {
        this.portfolioImageRepository = portfolioImageRepository;
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
        this.portfolioProjectRepository = portfolioProjectRepository;
        this.s3Wrapper = s3Wrapper;
        this.s3Wrapper.setBucket(bucketName+"/"+storeName);
    }

    public PortfolioImage create(String sessionId, Long project_id, PortfolioImage portfolioImage) {

        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioProject(project_id);

        Optional<PortfolioProject> portfolioProject = portfolioProjectRepository.findById(project_id);
        portfolioProject.ifPresent(portfolioImage::setPortfolioProject);

//        String fileFullPath = null;
//        try {
//            fileFullPath = uploadImageToS3(multipartFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return portfolioImageRepository.save(portfolioImage);
    }

    public List<PortfolioImage> getAllByPortfolioProjectOrderByCreated(String sessionId, Long project_id) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioProject(project_id);

        return portfolioImageRepository.findByPortfolioProjectOrderByCreated(portfolioProjectRepository.findById(project_id).get());
    }

//    public Optional<PortfolioImage> getOneById(String user_id, Long project_id, Long image_id) {
//        isUser(user_id);
//        isPortfolioProject(project_id);
//        return portfolioImageRepository.findById(image_id);
//    }

    public PortfolioImage update(String sessionId, Long project_id, Long image_id, PortfolioImage fetchedPortfolioImage) throws IOException {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioProject(project_id);

        final Optional<PortfolioImage> portfolioImage = portfolioImageRepository.findById(image_id);
        if(portfolioImage.isPresent()){
//            String fileFullPath = uploadImageToS3(multipartFile);
            Optional.ofNullable(fetchedPortfolioImage.getUrl()).ifPresent(f -> portfolioImage.get().setUrl(fetchedPortfolioImage.getUrl()));
            return portfolioImageRepository.save(portfolioImage.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String sessionId, Long project_id, Long image_id) {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioProject(project_id);

        Optional<PortfolioImage> portfolioImage = portfolioImageRepository.findById(image_id);
        portfolioImage.ifPresent(portfolioImageRepository::delete);
    }

    public void isUser(String user_id){
        userRepository.findByUuid(user_id)
                .orElseThrow(() -> new UsernameNotFoundException(user_id));
    }

    public void isPortfolioProject(Long project_id){
        portfolioProjectRepository.findById(project_id)
                .orElseThrow(() -> new UsernameNotFoundException(Long.toString(project_id)));
    }


    public void projectImageUpload(String sessionId, Long project_id, MultipartFile multipartFile) throws IOException {
        Session session = sessionRepository.findById(sessionId);
        String user_id = session.getAttribute("uuid");

        isUser(user_id);
        isPortfolioProject(project_id);

        PortfolioImage portfolioImage = new PortfolioImage();
        Optional<PortfolioProject> portfolioProject = portfolioProjectRepository.findById(project_id);
        portfolioProject.ifPresent(portfolioImage::setPortfolioProject);

        String fileName = UUID.randomUUID().toString().replace("-", "");
        String originName = multipartFile.getOriginalFilename();
        String exc = originName.substring(originName.lastIndexOf(".")+1, originName.length());
        String fileFullPath = bucketEndpoint+storeName+"/"+fileName+"."+exc;

        s3Wrapper.setBucket(bucketName+"/"+storeName);
        s3Wrapper.upload(multipartFile.getInputStream(), fileName+"."+exc);

        portfolioImage.setUrl(fileFullPath);
        portfolioImageRepository.save(portfolioImage);
    }

//    private String uploadImageToS3(MultipartFile multipartFile) throws IOException {
//        String fileName = UUID.randomUUID().toString().replace("-", "");
//        String originName = multipartFile.getOriginalFilename();
//        String exc = originName.substring(originName.lastIndexOf(".")+1, originName.length());
//        String fileFullPath = bucketEndpoint+storeName+"/"+fileName+"."+exc;
//
//        s3Wrapper.setBucket(bucketName);
//        s3Wrapper.upload(multipartFile.getInputStream(), fileName+"."+exc);
//
//        return fileFullPath;
//    }
}
