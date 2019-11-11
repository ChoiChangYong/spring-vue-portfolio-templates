package com.yyfolium.springbootrestserver.resume;

import com.yyfolium.springbootrestserver.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
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

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "history_flag", nullable = false)
    private Integer historyFlag;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    @Builder
    public Resume(User user, String job, String company, String description, Timestamp startDate, Timestamp endDate, int historyFlag) {
        this.user = user;
        this.job = job;
        this.company = company;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.historyFlag = historyFlag;
    }
}
