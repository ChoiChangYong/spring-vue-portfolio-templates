package com.yyfolium.springbootrestserver.portfolio.image;

import com.yyfolium.springbootrestserver.portfolio.project.PortfolioProject;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "portfolio_image")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="portfolio_project_id",nullable = false)
    private PortfolioProject portfolioProject;

    @Column(length = 255, nullable = false)
    private String url;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @Builder
    public PortfolioImage(PortfolioProject portfolioProject, String url) {
        this.portfolioProject = portfolioProject;
        this.url = url;
    }
}
