package com.service;

import com.model.Computer;
import com.repo.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    public Optional<Computer> findById(Long id) {
        return computerRepository.findById(id);
    }

    public Computer save(Computer computer) {
        return computerRepository.save(computer);
    }

    public void deleteById(Long id) {
        computerRepository.deleteById(id);
    }
}
