package com.service;

import com.model.Resume;
import com.model.User;
import com.repo.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume create(Resume resume) {
        return resumeRepository.save(resume);
    }

    public List<Resume> getByUser(User user) {
        return resumeRepository.findByOwner(user);
    }

    public Resume update(Resume resume) {
        return resumeRepository.save(resume);
    }

    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }
}
