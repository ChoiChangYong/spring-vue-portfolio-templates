package com.yyfolium.springbootrestserver.resume;

import com.yyfolium.springbootrestserver.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "resume")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id",nullable = false)
    private User user;

    @Column(length = 30, nullable = false)
    private String job;

    @Column(length = 50, nullable = false)
    private String company;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private Timestamp start_date;

    @Column(nullable = false)
    private Timestamp end_date;

    @Column(nullable = false)
    private int history_flag;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @Builder
    public Resume(User user, String job, String company, String description, Timestamp start_date, Timestamp end_date, int history_flag) {
        this.user = user;
        this.job = job;
        this.company = company;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.history_flag = history_flag;
    }
}
