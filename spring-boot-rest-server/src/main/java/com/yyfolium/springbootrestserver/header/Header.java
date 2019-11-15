package com.yyfolium.springbootrestserver.header;

import com.yyfolium.springbootrestserver.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "header")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Header {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id",nullable = false)
    private User user;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String intro;

    @Column(name = "sub_intro", length = 150, nullable = false)
    private String subIntro;

    @Column(name = "background_image_flag", nullable = false)
    private Integer backgroundImageFlag;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @Builder
    public Header(User user, String title, String intro, String subIntro, Integer backgroundImageFlag) {
        this.user = user;
        this.title = title;
        this.intro = intro;
        this.subIntro = subIntro;
        this.backgroundImageFlag = backgroundImageFlag;
    }
}
