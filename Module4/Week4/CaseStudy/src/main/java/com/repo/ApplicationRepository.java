package com.repo;

import com.model.Application;
import com.model.JobPost;
import com.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByCandidate(User user);
    List<Application> findByJobPost(JobPost jobPost);

    Optional<Application> findByCandidateAndJobPost(User user, JobPost jobPost);

    List<Application> findByCandidateAndStatus(User user, String status);
}
