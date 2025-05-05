package com.repo;

import com.model.job.Post;
import com.model.job.PostStatus;
import com.model.user.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByStatus(PostStatus status);
    List<Post> findByRecruiter(Recruiter recruiter);
}
