package com.model.user;

import com.model.Application;
import com.model.Resume;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class Worker extends User {

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Application> applications;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resume> resumes;

}
