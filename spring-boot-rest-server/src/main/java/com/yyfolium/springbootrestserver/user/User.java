package com.yyfolium.springbootrestserver.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter @Setter
@EqualsAndHashCode(of = "uuid")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Column(length = 32, nullable = false, unique = true)
    private String uuid;

    @Id
    @Column(length = 30)
    private String id;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer gender;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 15)
    private String tel;

    @Column(length = 255, nullable = false)
    private String imageUrl;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @Builder
    public User(String id, String password, String name, Integer gender, String email, String tel, String imageUrl) {
        this.uuid = UUID.randomUUID().toString().replace("-", "");
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.tel = tel;
        this.imageUrl = UUID.randomUUID().toString().replace("-", "");
    }
}
