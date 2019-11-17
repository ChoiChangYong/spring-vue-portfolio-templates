package com.yyfolium.springbootrestserver.portfolio.image;

import com.yyfolium.springbootrestserver.S3Wrapper;
import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProject;
import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProjectRepository;
import com.yyfolium.springbootrestserver.user.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PortfolioImageService {

    private final PortfolioImageRepository portfolioImageRepository;

    private final UserRepository userRepository;

    private final PortfolioProjectRepository portfolioProjectRepository;

    @Value("${cloud.aws.s3.bucket.name}")
    private String bucketName;

    @Value("${cloud.aws.s3.bucket.name.profile}")
    private String storeName;

    @Value("${cloud.aws.s3.bucket.endpoint}")
    private String bucketEndpoint;

    private final S3Wrapper s3Wrapper;

    public PortfolioImageService(PortfolioImageRepository portfolioImageRepository,
                                 UserRepository userRepository,
                                 PortfolioProjectRepository portfolioProjectRepository,
                                 S3Wrapper s3Wrapper) {
        this.portfolioImageRepository = portfolioImageRepository;
        this.userRepository = userRepository;
        this.portfolioProjectRepository = portfolioProjectRepository;
        this.s3Wrapper = s3Wrapper;
        this.s3Wrapper.setBucket(bucketName+"/"+storeName);
    }

    public PortfolioImage create(String user_id, Long project_id,
                                 MultipartFile multipartFile) {
        isUser(user_id);

        PortfolioImage newPortfolioImage = null;

        Optional<PortfolioProject> portfolioProject = portfolioProjectRepository.findById(project_id);

        String fileFullPath = null;
        try {
            fileFullPath = uploadImageToS3(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        newPortfolioImage = PortfolioImage.builder()
                .url(fileFullPath)
                .build();

        return portfolioImageRepository.save(newPortfolioImage);
    }

    public List<PortfolioImage> getAllByPortfolioProjectOrderByCreated(String user_id, Long project_id) {
        isUser(user_id);
        isPortfolioProject(project_id);
        return portfolioImageRepository.findByPortfolioProjectOrderByCreated(portfolioProjectRepository.findById(project_id).get());
    }

    public Optional<PortfolioImage> getOneById(String user_id, Long project_id, Long image_id) {
        isUser(user_id);
        isPortfolioProject(project_id);
        return portfolioImageRepository.findById(image_id);
    }

    public PortfolioImage update(String user_id, Long project_id, Long image_id,
                                 MultipartFile multipartFile) throws IOException {
        isUser(user_id);
        isPortfolioProject(project_id);
        final Optional<PortfolioImage> portfolioImage = portfolioImageRepository.findById(image_id);
        if(portfolioImage.isPresent()){
            String fileFullPath = uploadImageToS3(multipartFile);
            portfolioImage.get().setUrl(fileFullPath);
            return portfolioImageRepository.save(portfolioImage.get());
        }
        else{
            return null;
        }
    }

    public void deleteById(String user_id, Long project_id, Long image_id) {
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

    private String uploadImageToS3(MultipartFile multipartFile) throws IOException {
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String originName = multipartFile.getOriginalFilename();
        String exc = originName.substring(originName.lastIndexOf(".")+1, originName.length());
        String fileFullPath = bucketEndpoint+storeName+"/"+fileName+"."+exc;

        s3Wrapper.setBucket(bucketName);
        s3Wrapper.upload(multipartFile.getInputStream(), fileName+"."+exc);

        return fileFullPath;
    }
}
