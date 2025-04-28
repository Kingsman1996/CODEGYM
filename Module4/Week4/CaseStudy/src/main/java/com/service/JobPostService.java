package com.service;


import com.model.JobPost;
import com.model.user.User;
import com.repo.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    @Autowired
    public JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public JobPost create(JobPost jobPost) {
        jobPost.setStatus("PENDING");
        return jobPostRepository.save(jobPost);
    }

    public List<JobPost> getApproved() {
        return jobPostRepository.getByStatus("APPROVED");
    }

    public List<JobPost> getByUser(User user) {
        return jobPostRepository.getByUser(user);
    }

    public Optional<JobPost> getById(Long id) {
        return jobPostRepository.findById(id);
    }

    public void approve(Long postId) {
        Optional<JobPost> optional = jobPostRepository.findById(postId);
        optional.ifPresent(post -> {
            post.setStatus("APPROVED");
            jobPostRepository.save(post);
        });
    }

    public void reject(Long postId) {
        Optional<JobPost> optional = jobPostRepository.findById(postId);
        optional.ifPresent(post -> {
            post.setStatus("REJECTED");
            jobPostRepository.save(post);
        });
    }

    public void delete(Long id) {
        jobPostRepository.deleteById(id);
    }
}
