package com.yyfolium.springbootrestserver.auth;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "SPRING_SESSION")
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Session {

    @Id
    @Column(name = "PRIMARY_ID", nullable = false)
    private String primaryId;

    @Column(name = "SESSION_ID", nullable = false, unique = true)
    private String sessionId;

    @Column(name = "CREATION_TIME", nullable = false)
    private BigInteger creationTime;

    @Column(name = "LAST_ACCESS_TIME", nullable = false)
    private BigInteger lastAccessTime;

    @Column(name = "MAX_INACTIVE_INTERVAL", nullable = false)
    private Integer maxInactiveInterval;

    @Column(name = "EXPIRY_TIME", nullable = false)
    private BigInteger expiryTime;

    @Column(name = "PRINCIPAL_NAME")
    private String principalName;
}
