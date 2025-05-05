package com.service;

import com.model.user.*;
import com.repo.CandidateRepository;
import com.repo.ContactInfoRepository;
import com.repo.RecruiterRepository;
import com.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final ContactInfoRepository contactInfoRepository;
    private final RecruiterRepository recruiterRepository;
    private final CandidateRepository candidateRepository;

    @Autowired
    public UserService(UserRepository userRepository, ContactInfoRepository contactInfoRepository,
                       RecruiterRepository recruiterRepository, CandidateRepository candidateRepository) {
        this.userRepository = userRepository;
        this.contactInfoRepository = contactInfoRepository;
        this.recruiterRepository = recruiterRepository;
        this.candidateRepository = candidateRepository;
    }

    public void register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Tài khoản đã tồn tại");
        }
        userRepository.save(user);
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setUser(user);
        contactInfoRepository.save(contactInfo);
        switch (user.getRole()) {
            case RECRUITER:
                Recruiter recruiter = new Recruiter();
                recruiter.setUser(user);
                recruiterRepository.save(recruiter);
                break;
            case WORKER:
                Candidate candidate = new Candidate();
                candidate.setUser(user);
                candidateRepository.save(candidate);
                break;
        }
    }

    public boolean checkLogin(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }

    public void update(User updatedUser) {
        Optional<User> userOptional = userRepository.findById(updatedUser.getId());
        if (userOptional.isPresent()) {
            User foundUser = userOptional.get();
            foundUser.setPassword(updatedUser.getPassword());
            userRepository.save(foundUser);
        }
    }
}
