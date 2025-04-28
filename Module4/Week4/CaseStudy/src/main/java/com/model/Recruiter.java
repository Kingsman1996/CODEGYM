package com.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class Recruiter extends User {
    @OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL)
    private List<JobPost> jobPosts;
}
