package com.repo;

import com.model.JobPost;
import com.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    List<JobPost> getByStatus(String status);
    List<JobPost> getByUser(User user);
}
