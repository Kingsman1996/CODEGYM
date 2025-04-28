package com.service;

import com.model.Application;
import com.model.JobPost;
import com.model.user.User;
import com.repo.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application apply(User user, JobPost jobPost) {
        Optional<Application> existingApplication = applicationRepository.findByCandidateAndJobPost(user, jobPost);
        if (existingApplication.isPresent()) {
            throw new IllegalArgumentException("Người dùng đã ứng tuyển cho bài đăng tuyển dụng này");
        }

        Application application = new Application();
        application.setCandidate(user);
        application.setJobPost(jobPost);
        application.setStatus("Pending");
        return applicationRepository.save(application);
    }

    public List<Application> getByJobPost(JobPost jobPost) {
        return applicationRepository.findByJobPost(jobPost);
    }

    public Application update(Long applicationId, String status) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new IllegalArgumentException("Ứng tuyển không tồn tại"));
        application.setStatus(status);
        return applicationRepository.save(application);
    }

    public void delete(Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new IllegalArgumentException("Ứng tuyển không tồn tại"));
        applicationRepository.deleteById(applicationId);
    }

    public List<Application> getByCandidateAndStatus(User user, String status) {
        return applicationRepository.findByCandidateAndStatus(user, status);
    }
}
