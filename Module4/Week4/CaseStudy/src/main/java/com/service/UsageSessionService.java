package com.service;

import com.model.UsageSession;
import com.repo.UsageSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsageSessionService {
    private final UsageSessionRepository usageSessionRepository;

    @Autowired
    public UsageSessionService(UsageSessionRepository usageSessionRepository) {
        this.usageSessionRepository = usageSessionRepository;
    }

    public List<UsageSession> findAll() {
        return usageSessionRepository.findAll();
    }

    public Optional<UsageSession> findById(Long id) {
        return usageSessionRepository.findById(id);
    }

    public UsageSession save(UsageSession session) {
        return usageSessionRepository.save(session);
    }

    public void deleteById(Long id) {
        usageSessionRepository.deleteById(id);
    }
}
