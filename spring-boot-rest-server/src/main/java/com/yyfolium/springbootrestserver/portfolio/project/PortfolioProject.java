package com.yyfolium.springbootrestserver.portfolio.project;

import com.yyfolium.springbootrestserver.portfolio.menu.PortfolioMenu;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "portfolio_project")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="portfolio_menu_id")
    private PortfolioMenu portfolioMenu;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String belong;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @Builder
    public PortfolioProject(PortfolioMenu portfolioMenu, String name, String description) {
        this.portfolioMenu = portfolioMenu;
        this.name = name;
        this.description = description;
    }
}
