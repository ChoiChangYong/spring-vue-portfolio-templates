package com.yyfolium.springbootrestserver.auth;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "SPRING_SESSION_ATTRIBUTES")
@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SessionAttributes {

    @Id
    @ManyToOne(targetEntity = Session.class)
    @JoinColumn(name ="user_id",nullable = false)
    private Session session;

    @Id
    @Column(name = "ATTRIBUTE_NAME", nullable = false)
    private String attributeName;

    @Column(name = "ATTRIBUTE_BYTES", nullable = false)
    private Blob attributeBytes;

}
