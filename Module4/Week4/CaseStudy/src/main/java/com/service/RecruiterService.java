package com.service;

import com.model.user.Recruiter;
import com.model.user.User;
import com.repo.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;

    @Autowired
    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public Recruiter findByUser(User user) {
        Optional<Recruiter> optionalRecruiter = recruiterRepository.findByUser(user);
        return optionalRecruiter.orElse(null);
    }
}
