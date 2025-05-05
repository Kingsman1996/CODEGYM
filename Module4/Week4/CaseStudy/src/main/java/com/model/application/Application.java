package com.model.application;

import com.model.job.Post;
import com.model.user.Candidate;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Post post;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private LocalDate appliedAt;
}
