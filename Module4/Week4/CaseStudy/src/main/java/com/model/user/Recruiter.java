package com.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    @OneToOne
    private User user;
}
