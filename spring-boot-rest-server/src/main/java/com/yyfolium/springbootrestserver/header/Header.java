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

    @Column(length = 50, nullable = false)
    private int sub_intro;

    @Column(length = 255, nullable = false)
    private String image_url;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @Builder
    public Header(User user, String title, String intro, int sub_intro, String image_url) {
        this.user = user;
        this.title = title;
        this.intro = intro;
        this.sub_intro = sub_intro;
        this.image_url = image_url;
    }
}
