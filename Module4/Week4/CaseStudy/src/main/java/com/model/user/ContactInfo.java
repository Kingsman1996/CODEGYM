package com.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String address;

    @OneToOne
    private User user;
}
