package com.service;

import com.model.user.Candidate;
import com.model.user.User;
import com.repo.ApplicationRepository;
import com.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public CandidateService(ApplicationRepository applicationRepository, CandidateRepository candidateRepository) {
        this.applicationRepository = applicationRepository;
        this.candidateRepository = candidateRepository;
    }

    public Candidate findByUser(User user) {
        return candidateRepository.findByUser(user);
    }
}
