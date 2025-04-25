package com.service;

import com.model.Province;
import com.repo.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    public void save(Province province) {
        provinceRepository.save(province);
    }

    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
