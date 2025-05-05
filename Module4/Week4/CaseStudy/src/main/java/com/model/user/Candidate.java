package com.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cvLink;

    @OneToOne
    private User user;
}
